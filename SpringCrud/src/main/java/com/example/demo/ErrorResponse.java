package com.example.demo;

public class ErrorResponse {
	
	private long timestamp;
	
	private int status;
	
	private String message;

	public ErrorResponse() {
		
	}

	public ErrorResponse(long timestamp, int status, String message) {
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
