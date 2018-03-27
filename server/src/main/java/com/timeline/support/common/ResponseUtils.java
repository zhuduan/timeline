package com.timeline.support.common;

public class ResponseUtils {

  public static final String SUCCESS = "success";

  public static final String FAILURE = "failure";

  public static final int SuccessStatus = 200;

  public static final int FailureStatus = 500;

  public static final int NeedLoginStatus = 100;

  private static <T> ResultWrapper<T> wrap(T data, int status, String msg) {

    ResultWrapper<T> resultWrapper = new ResultWrapper<>();
    resultWrapper.setMsg(msg);
    resultWrapper.setData(data);
    resultWrapper.setStatus(status);
    return resultWrapper;
  }

  private static class ResultWrapper<T> {

    private int status;

    private T data;

    private String msg;

    public String getMsg() {
      return msg;
    }

    public void setMsg(final String msg) {
      this.msg = msg;
    }

    public int getStatus() {
      return status;
    }

    public void setStatus(final int status) {
      this.status = status;
    }

    public T getData() {
      return data;
    }

    public void setData(final T data) {
      this.data = data;
    }
  }

  public static <T> ResultWrapper<T> toSuccess(T data) {

    return wrap(data, SuccessStatus, SUCCESS);
  }

  public static <T> ResultWrapper<T> toFailure(T data, int status) {

    return wrap(data, status, FAILURE);
  }

  public static <T> ResultWrapper<T> toFailure(T data) {

    return toFailure(data, FailureStatus);
  }

  public static boolean isWraped(Object obj) {

    if (obj != null && obj instanceof ResultWrapper) {
      return true;
    }

    return false;
  }
}
