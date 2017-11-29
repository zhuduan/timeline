package com.timeline.controller;

import com.timeline.common.ResponseUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {


	@ExceptionHandler(value = Exception.class)
	public Object exceptionHandler(HttpServletRequest request,
								   HttpServletResponse response,
								   Exception exception) throws Exception {

		response.setStatus(200);
		WebUtils.clearErrorRequestAttributes(request);

		StringBuilder message = new StringBuilder();
		message.append("your request [ ")
		       .append(request.getMethod())
		       .append(", ")
		       .append(request.getRequestURI())
		       .append(" ] ")
		       .append(", error info: ")
		       .append(exception.getMessage());
		return ResponseUtils.toFailure(message.toString(), 500);
	}
}