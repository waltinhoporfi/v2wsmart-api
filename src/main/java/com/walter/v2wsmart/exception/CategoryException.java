package com.walter.v2wsmart.exception;

public class CategoryException extends RuntimeException {

	private static final long serialVersionUID = 8920431080584200235L;

	public CategoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public CategoryException(String message) {
		super(message);
	}
	
}
