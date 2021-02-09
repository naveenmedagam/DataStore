package com.demo.data.store.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskData {

	private String channel;
	private String conversationId;
	private String country;
	
	@JsonProperty("json_data")
	private JsonData JsonData;
	@JsonProperty("security")
	private SecurityInfo security;
	
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getConversationId() {
		return conversationId;
	}
	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public JsonData getJsonData() {
		return JsonData;
	}
	public void setJsonData(JsonData jsonData) {
		JsonData = jsonData;
	}
	public SecurityInfo getSecurity() {
		return security;
	}
	public void setSecurity(SecurityInfo security) {
		this.security = security;
	}
	@Override
	public String toString() {
		return "TaskData [channel=" + channel + ", conversationId=" + conversationId + ", country=" + country
				+ ", JsonData=" + JsonData + ", security=" + security + "]";
	}
	
	
	

}
