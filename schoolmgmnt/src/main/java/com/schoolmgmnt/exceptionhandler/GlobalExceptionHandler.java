package com.schoolmgmnt.exceptionhandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	 public ResponseEntity<Map<String, List<String>>>  handlingErrors(MethodArgumentNotValidException ex)
	{
	List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
	return new ResponseEntity<>(getErrorMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	 private Map<String, List<String>> getErrorMap(List<String> errors){
		 Map<String, List<String>> errorResponse = new HashMap<>();
		 errorResponse.put("errors", errors);
		 return errorResponse;
	 }
	 @ExceptionHandler(DataNotFoundException.class)
	 public ResponseEntity<Map<String, List<String>>> handlingDataNotFoundException(DataNotFoundException ex)
		{
		List<String> errors = Collections.singletonList(ex.getMessage());
		return new ResponseEntity<>(getErrorMap(errors), new HttpHeaders(), HttpStatus.NOT_FOUND);
		}
	 @ExceptionHandler(DataNotHandledException.class)
	 public ResponseEntity<Map<String, List<String>>> handleDataNotFoundException(DataNotHandledException ex)
		{
		List<String> errors = Collections.singletonList(ex.getMessage());
		return new ResponseEntity<>(getErrorMap(errors), new HttpHeaders(), HttpStatus.NOT_MODIFIED);
		}
	 @ExceptionHandler(DataNotAcceptableException.class)
	 public ResponseEntity<Map<String, List<String>>> dataNotAcceptableException(DataNotAcceptableException ex)
		{
		List<String> errors = Collections.singletonList(ex.getMessage());
		return new ResponseEntity<>(getErrorMap(errors), new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
		}

}
