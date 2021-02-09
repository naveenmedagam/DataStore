package com.demo.data.store.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecurityInfo {
	
	@JsonProperty("client_ip")
	private String clientIp;
	@JsonProperty("auth_token")
	private String authToken;

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	@Override
	public String toString() {
		return "SecurityInfo [clientIp=" + clientIp + ", authToken=" + authToken + "]";
	}

}
