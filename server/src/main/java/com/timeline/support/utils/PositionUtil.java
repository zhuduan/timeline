package com.timeline.support.utils;

public class PositionUtil {

  private static int originStackIndex = 2;

  public static String getFileName() {
    return Thread.currentThread().getStackTrace()[originStackIndex].getFileName();
  }

  public static String getClassName() {
    return Thread.currentThread().getStackTrace()[originStackIndex].getClassName();
  }

  public static String getMethodName() {
    return Thread.currentThread().getStackTrace()[originStackIndex].getMethodName();
  }

  public static int getLineNumber() {
    return Thread.currentThread().getStackTrace()[originStackIndex].getLineNumber();
  }

  public static String getPositionInfo() {
    StackTraceElement element = Thread.currentThread().getStackTrace()[originStackIndex];
    return (element.getClassName() + " at line " + element.getLineNumber());
  }
}
