package com.demo.data.store.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name ="task")
public class Task {
	
	@Id
	@Column(name="task_token")
	private String taskToken;
	
	@Column(name="channel")
	private String channel;
	
	@Column(name="created_at")
	private Long createdTimeStamp;
	
	@Column(name="expiring_at")
	private Long expiringTimeStamp;
	
	@Column(name="updated_at")
	private Long updatedTImeStamp;
	
	@Column(name="type")
	private String type;
	
	@Column(name="data")
	private String data;
	
	@Column(name="status")
	private String status;
	

	public String getTaskToken() {
		return taskToken;
	}

	public void setTaskToken(String taskToken) {
		this.taskToken = taskToken;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Long getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Long createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public Long getExpiringTimeStamp() {
		return expiringTimeStamp;
	}

	public void setExpiringTimeStamp(Long expiringTimeStamp) {
		this.expiringTimeStamp = expiringTimeStamp;
	}

	public Long getUpdatedTImeStamp() {
		return updatedTImeStamp;
	}

	public void setUpdatedTImeStamp(Long updatedTImeStamp) {
		this.updatedTImeStamp = updatedTImeStamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	


}
