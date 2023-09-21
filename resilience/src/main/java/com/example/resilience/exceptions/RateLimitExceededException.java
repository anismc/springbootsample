package com.example.resilience.exceptions;

public class RateLimitExceededException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 145645647L;
	String errorCode;
	
	public RateLimitExceededException(String message,String erroCode) {
		super(message);
		this.errorCode=erroCode;
		// TODO Auto-generated constructor stub
	}

	public String getErrorCode() {
		return errorCode;
	}
}
