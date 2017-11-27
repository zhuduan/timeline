package com.timeline.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {


	@ExceptionHandler(value = Exception.class)
	public Object exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		
		System.out.println("exception: " + exception.getMessage());
		exception.printStackTrace();
		return exception.getMessage();
	}
}