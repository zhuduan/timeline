package com.timeline.support.annotation;

import com.google.common.collect.Sets;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class UserLoginHolder {

  private boolean isGlobal = false;
  private Class<?> classType;
  private Set<String> exclusive = Sets.newConcurrentHashSet();
  private Set<Method> methodSet = Sets.newConcurrentHashSet();

  public UserLoginHolder() {

  }

  public UserLoginHolder(boolean isGlobal, Class<?> classType, String[] exclusive) {
    setGlobal(isGlobal);
    setClassType(classType);
    addExclusiveMethodName(exclusive);
  }

  public boolean needCheck(Method method) {
    return isGlobal() && !isExcusiveMethod(method.getName()) || (!isGlobal() && isNeedCheckMethod(method));
  }

  public boolean isGlobal() {
    return isGlobal;
  }

  public void setGlobal(boolean global) {
    this.isGlobal = global;
  }

  public void addMethod(Method method) {
    methodSet.add(method);
  }

  public void addMethod(Collection<Method> method) {
    methodSet.addAll(method);
  }

  public boolean isNeedCheckMethod(Method method) {
    return methodSet.contains(method) ;
  }

  public void addExclusiveMethodName(String methodName) {
    exclusive.add(methodName);
  }

  public void addExclusiveMethodName(Collection<String> methodNames) {
    exclusive.addAll(methodNames);
  }

  public void addExclusiveMethodName(String[] methodNames) {

    if (methodNames == null || methodNames.length == 0) {
      return;
    }

    exclusive.addAll(Arrays.asList(methodNames));
  }

  public boolean isExcusiveMethod(String name) {
    return exclusive.contains(name);
  }

  public Class<?> getClassType() {
    return classType;
  }

  public void setClassType(final Class<?> classType) {
    this.classType = classType;
  }
}
