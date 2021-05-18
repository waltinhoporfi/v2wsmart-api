package com.walter.v2wsmart.exception;

public class ProductInvalidException extends RuntimeException {

	private static final long serialVersionUID = -2700553195068440972L;

	public ProductInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductInvalidException(String message) {
		super(message);
	}

}
