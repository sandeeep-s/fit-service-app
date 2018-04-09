package com.gefa.fit.boundary.inbound.v0_0_0.rest.error;

public class GeneralErrorCode {

	private String statusCode;

	private String applicationErrorCode;

	private String userMessage;

	public GeneralErrorCode(String statusCode, String applicationErrorCode, String userMessage) {
		this.statusCode = statusCode;
		this.applicationErrorCode = applicationErrorCode;
		this.userMessage = userMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getApplicationErrorCode() {
		return applicationErrorCode;
	}

	public String getUserMessage() {
		return userMessage;
	}

}
