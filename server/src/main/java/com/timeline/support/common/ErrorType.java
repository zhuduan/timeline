package com.timeline.support.common;

public enum ErrorType {

  INVALID_INPUT_PARAM(1, "wrong input param"),
  NOT_FOUND_RESOURCE(2, "not find resource request for");

  private int errorCode;

  private String errorMsg;

  ErrorType(int code, String msg) {
    this.errorCode = code;
    this.errorMsg = msg;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

}
