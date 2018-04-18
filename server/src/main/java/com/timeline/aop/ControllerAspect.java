package com.timeline.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.timeline.support.common.ResponseUtils;

@Aspect
@Order(1)
@Component
public class ControllerAspect {

  @Pointcut("execution(* com.timeline.controller..*.*(..))")
  public void resultAspect() {
  }

  @Around(value = "resultAspect()")
  public Object wrapResult(ProceedingJoinPoint joinPoint) {

    try {
      Object obj = joinPoint.proceed();
      if (ResponseUtils.isWraped(obj)) {
        return obj;
      }
      return ResponseUtils.toSuccess(obj);
    } catch (Throwable t) {
      return ResponseUtils.toFailure(t.getMessage());
    }
  }
}
