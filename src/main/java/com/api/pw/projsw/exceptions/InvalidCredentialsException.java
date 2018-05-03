package com.api.pw.projsw.exceptions;

public class InvalidCredentialsException extends NullPointerException{
	private static final long serialVersionUID = -237860835863404438L;

	public InvalidCredentialsException(String message) {
	  super(message);
	}
}