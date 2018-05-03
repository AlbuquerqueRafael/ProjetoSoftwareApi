package com.api.pw.projsw.frontend;

import java.util.HashMap;
import java.util.Map;

import com.api.pw.projsw.exceptions.InvalidCredentialsException;
import com.api.pw.projsw.exceptions.MessageInvalidException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class FrontEndExceptionHandler {
	private Map<String, Object> model = new HashMap<String, Object>();
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<Map<String, Object>> handleCustomException(InvalidCredentialsException e) {
		return mountBadRequestException(e.getMessage());
	}
	
	private ResponseEntity<Map<String, Object>> mountBadRequestException(String errorMessage){
		model.put("error", errorMessage);
		
		return new ResponseEntity<Map<String, Object>>(model, HttpStatus.BAD_REQUEST);
	}
	
}