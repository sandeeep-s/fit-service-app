package com.gefa.fit.application.exceptions;

public class NoSuchAssetException extends RuntimeException {

	private static final long serialVersionUID = -2194218553127535845L;

	public NoSuchAssetException(String message) {
		super(message);
	}

}
