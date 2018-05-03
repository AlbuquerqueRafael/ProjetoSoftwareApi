package com.api.pw.projsw.msg;

import java.util.HashMap;
import java.util.Map;

import com.api.pw.projsw.exceptions.InvalidCredentialsException;
import com.api.pw.projsw.exceptions.MessageInvalidException;
import com.api.pw.projsw.exceptions.MessageNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class MessageExceptionHandler {
	private Map<String, Object> model = new HashMap<String, Object>();
	
	@ExceptionHandler(MessageInvalidException.class)
	public ResponseEntity<Map<String, Object>> handleCustomException(MessageInvalidException e) {
		return mountBadRequestException(e.getMessage(), e.getClass().getSimpleName());
	}
	
	@ExceptionHandler(MessageNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleCustomException(MessageNotFoundException e) {
		return mountBadRequestException(e.getMessage(), e.getClass().getSimpleName());
  }

  @ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<Map<String, Object>> handleCustomException(InvalidCredentialsException e) {
		return mountBadRequestException(e.getMessage(), e.getClass().getSimpleName());
  }
  
	
	private ResponseEntity<Map<String, Object>> mountBadRequestException(String errorMessage, String exceptionName){
		model.put("error", errorMessage);
		
		return new ResponseEntity<Map<String, Object>>(model, HttpStatus.BAD_REQUEST);
	}
	
}