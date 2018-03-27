package com.timeline.controller;

/*
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.timeline.support.common.ResponseUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  public Object exceptionHandler(HttpServletRequest request,
      HttpServletResponse response,
      Exception exception) {

    response.setStatus(200);
    WebUtils.clearErrorRequestAttributes(request);

    //do some things such as print log
    return ResponseUtils.toFailure(exception.getMessage(), 500);
  }
}*/
