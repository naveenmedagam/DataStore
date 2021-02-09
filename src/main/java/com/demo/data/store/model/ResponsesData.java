package com.demo.data.store.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponsesData {
	
	@JsonProperty("created_at")
	private String ceatedTimeStamp;
	@JsonProperty("expiring_at")
	private String expiringTimeStamp;
	@JsonProperty("type")
	private String type;
	@JsonProperty("updated_at")
	private String updatedTimeStamp;
	@JsonProperty("task_token")
	private String task_token;
	@JsonProperty("security")
	private SecurityInfo securityInfo;
	
	public String getCeatedTimeStamp() {
		return ceatedTimeStamp;
	}
	public void setCeatedTimeStamp(String ceatedTimeStamp) {
		this.ceatedTimeStamp = ceatedTimeStamp;
	}
	public String getExpiringTimeStamp() {
		return expiringTimeStamp;
	}
	public void setExpiringTimeStamp(String expiringTimeStamp) {
		this.expiringTimeStamp = expiringTimeStamp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}
	public void setUpdatedTimeStamp(String updatedTimeStamp) {
		this.updatedTimeStamp = updatedTimeStamp;
	}
	public String getTask_token() {
		return task_token;
	}
	public void setTask_token(String task_token) {
		this.task_token = task_token;
	}
	public SecurityInfo getSecurityInfo() {
		return securityInfo;
	}
	public void setSecurityInfo(SecurityInfo securityInfo) {
		this.securityInfo = securityInfo;
	}
	@Override
	public String toString() {
		return "ResponsesData [ceatedTimeStamp=" + ceatedTimeStamp + ", expiringTimeStamp=" + expiringTimeStamp
				+ ", type=" + type + ", updatedTimeStamp=" + updatedTimeStamp + ", task_token=" + task_token
				+ ", securityInfo=" + securityInfo + "]";
	}
	
	
	
}
