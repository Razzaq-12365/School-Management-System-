package com.schoolmgmnt.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class DataNotAcceptableException extends RuntimeException {

	public DataNotAcceptableException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataNotAcceptableException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
