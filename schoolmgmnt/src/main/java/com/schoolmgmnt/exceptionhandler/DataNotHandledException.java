package com.schoolmgmnt.exceptionhandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_MODIFIED)
public class DataNotHandledException extends RuntimeException {

	public DataNotHandledException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataNotHandledException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
