package com.demo.data.store.service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.demo.data.store.config.TokenConfig;
import com.demo.data.store.entity.Task;
import com.demo.data.store.model.ResponsesData;
import com.demo.data.store.model.SecurityInfo;
import com.demo.data.store.model.TaskData;
import com.demo.data.store.repository.StoreReposity;
import com.demo.data.store.rest.DataStoreController;

@Service
public class StoreService {
	private static final Logger LOGGER = LoggerFactory.getLogger(StoreService.class);

	@Autowired
	private StoreReposity storeReposity;
	
	@Autowired
	private TokenConfig tokenConfig;

	public void saveTask(TaskData taskData, ResponsesData responsesData) {
		Task task = new Task();
		try {
			populateTask(taskData, task);
			storeReposity.save(task);
			populateResponeData(taskData, task, responsesData);
		} catch (Exception e) {
			LOGGER.error("Exception encounter while saving record: {}", e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request");
		}

	}

	public void updateTask(ResponsesData responsesData) {
		java.util.Optional<Task> task = storeReposity.findById(responsesData.getTask_token());
		if (task.isPresent()) {
			task.get().setStatus("RESUMED");
			storeReposity.save(task.get());
		} else {
			LOGGER.info("Record not found for data :{}", responsesData);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity Not Found");
		}
	}

	// Get all tasks from the h2 database.
	public List<Task> getAll() {
		final List<Task> tasks = new ArrayList<Task>();
		storeReposity.findAll().forEach(task -> tasks.add(task));
		return tasks;
	}

	private void populateTask(TaskData taskData, Task task) {
		task.setData(getDecodedString(taskData));
		task.setChannel(task.getChannel());
		task.setCreatedTimeStamp(Instant.now().toEpochMilli());
		task.setUpdatedTImeStamp(Instant.now().toEpochMilli());
		task.setExpiringTimeStamp(Instant.now().toEpochMilli());
		task.setTaskToken(UUID.randomUUID().toString());
		task.setType(taskData.getJsonData().getType());
		task.setStatus("SUBMITTED");
	}

	private void populateResponeData(TaskData taskInputData, Task task, ResponsesData responsesData) {
		responsesData.setCeatedTimeStamp(task.getCreatedTimeStamp().toString());
		responsesData.setExpiringTimeStamp(task.getExpiringTimeStamp().toString());
		responsesData.setSecurityInfo(taskInputData.getSecurity());
		responsesData.setUpdatedTimeStamp(task.getUpdatedTImeStamp().toString());
		responsesData.setTask_token(task.getTaskToken());
		responsesData.setType(task.getType());

	}

	private String getDecodedString(TaskData taskData) {
		try {
			return new String(Base64.getDecoder().decode(taskData.getJsonData().getBlob().getBytes()), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "BAd Input Data");
		}

	}

	public boolean validateToken(SecurityInfo securityInfo) {
	return securityInfo.getAuthToken().equals(tokenConfig.getToken());
		
	}

}
