package com.cg.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.exceptions.UserNotFoundException;
import com.cg.model.ExceptionsClass;


@ControllerAdvice
@RestController
public class ExceptionsHandlerClass extends ResponseEntityExceptionHandler {

	String time = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(new Date());
	@ExceptionHandler(value = UserNotFoundException.class)
	 public final ResponseEntity<ExceptionsClass> handleNotFoundException(UserNotFoundException notFoundException, WebRequest request) {
		ExceptionsClass exceptionsClass = new ExceptionsClass(Long.parseLong(time), notFoundException.getMessage(),request.getDescription(false));
		    return new ResponseEntity<>(exceptionsClass, HttpStatus.NOT_FOUND);
	   }
}
