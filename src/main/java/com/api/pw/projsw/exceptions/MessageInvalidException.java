package com.api.pw.projsw.exceptions;

public class MessageInvalidException extends NullPointerException{
	private static final long serialVersionUID = -237860835863404438L;

	public MessageInvalidException(String message) {
	  super(message);
	}
}