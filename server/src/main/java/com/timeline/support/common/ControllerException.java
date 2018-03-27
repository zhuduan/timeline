package com.timeline.support.common;

@SuppressWarnings("serial")
public class ControllerException extends Exception {

  public ControllerException(ErrorType errorType) {
    super(errorType.getErrorMsg());
  }
}
