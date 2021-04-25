package com.ykko.entity;

public class Response {

	private String id;
	private int statusCode;
	private String content;
	
	public Response() {}
	public Response(String id, int statusCode, String content) {
		this.id = id;
		this.statusCode = statusCode;
		this.content = content;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}	
}
