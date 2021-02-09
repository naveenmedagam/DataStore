package com.demo.data.store.model;

public class JsonData {
	
	
	private String blob;
	private String type;
	
	
	public String getBlob() {
		return blob;
	}
	public void setBlob(String blob) {
		this.blob = blob;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "JsonData [blob=" + blob + ", type=" + type + "]";
	}
	
	

}
