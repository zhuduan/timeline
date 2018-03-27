package com.timeline.aop;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.timeline.model.PO.User;
import com.timeline.support.common.ResponseUtils;
import com.timeline.support.http.HttpKeys;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Order(1)
@Component
public class ControllerAspect {

  @Pointcut("execution(* com.timeline.controller..*.*(..))")
  public void resultAspect() {
  }

  @PostConstruct
  public void init() {
    System.out.printf("test.............");
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
      return ResponseUtils.toFailure(t);
    }
  }

  /**
   *
   *          UserLogin
   *
   *
   *
   * */
  @Pointcut("execution(* com.timeline.controller..*.*(..))")
  public void justController() {
  }

  @Pointcut("@within(com.timeline.support.annotation.UserLogin)")
  public void withinUserLogin() {
  }

  @Pointcut("@annotation(com.timeline.support.annotation.UserLogin)")
  public void userLoginAnnotation() {
  }

  private static boolean allowClientSend = false;

  @Before("justController() && (withinUserLogin() || userLoginAnnotation())")
  public void userLogin() {
    Subject subject = SecurityUtils.getSubject();
    if (subject == null) {
      throw new RuntimeException("user not login");
    }

    if (subject.getSession() == null || subject.getPrincipal() == null) {
      throw new RuntimeException("user not login");
    }

    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

    if (request.getAttribute(HttpKeys.X_USER_ID) == null) {
      User user = (User) subject.getPrincipal();
      request.setAttribute(HttpKeys.X_USER_ID, user.getId());
    } else if (request.getAttribute(HttpKeys.X_USER_ID) != null && allowClientSend){
      throw new RuntimeException("client can't send X-USER-ID, it should be parsed by server from session");
    }
  }
}
