package com.demo.data.store.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.data.store.entity.Task;
import com.demo.data.store.model.ResponseMessage;
import com.demo.data.store.model.ResponsesData;
import com.demo.data.store.model.TaskData;
import com.demo.data.store.service.StoreService;

@RestController
@RequestMapping(path = "/api")
public class DataStoreController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataStoreController.class);

	@Autowired
	public StoreService storeService;

	@RequestMapping(value = "/task/create", method = RequestMethod.POST)
	public ResponseEntity<ResponsesData> saveTask(@RequestBody TaskData taskData) {

		LOGGER.info("Input data: {}",taskData);
		ResponsesData responsesData = new ResponsesData();

		if (taskData.getSecurity() != null && storeService.validateToken(taskData.getSecurity())) {
			storeService.saveTask(taskData, responsesData);
		} else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "ACCESS DENIED");
		}

		return new ResponseEntity<ResponsesData>(responsesData, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/task/update", method = RequestMethod.PUT)
	public ResponseEntity<ResponseMessage> updateTask(@RequestBody ResponsesData inpuptData) {
		if (inpuptData.getSecurityInfo() != null && storeService.validateToken(inpuptData.getSecurityInfo())) {
			storeService.updateTask(inpuptData);
		} else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "ACCESS DENIED");
		}
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("success", "Task has been resumed"),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public List<Task> getTasks() {
		return storeService.getAll();

	}

}
