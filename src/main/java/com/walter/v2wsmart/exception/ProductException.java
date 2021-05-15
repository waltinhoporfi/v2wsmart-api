package com.walter.v2wsmart.exception;

public class ProductException extends RuntimeException {

	private static final long serialVersionUID = -2868414351623185357L;

	public ProductException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductException(String message) {
		super(message);
	}

}
