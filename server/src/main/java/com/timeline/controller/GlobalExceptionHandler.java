package com.timeline.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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