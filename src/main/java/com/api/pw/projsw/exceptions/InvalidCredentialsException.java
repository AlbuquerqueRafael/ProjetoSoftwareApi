package com.api.pw.projsw.exceptions;

public class InvalidCredentialsException extends NullPointerException{
	private static final long serialVersionUID = -3123213;

	public InvalidCredentialsException (String message) {
	  super(message);
	}
}