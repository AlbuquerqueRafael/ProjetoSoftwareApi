package com.api.pw.projsw.exceptions;

public class MessageNotFoundException extends NullPointerException{
	private static final long serialVersionUID = -23786033835404438L;

	public MessageNotFoundException (String message) {
	  super(message);
	}
}