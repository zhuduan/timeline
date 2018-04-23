package com.timeline.interceptor;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.ExecutionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.servlet.ShiroHttpServletResponse;
import org.apache.shiro.web.subject.WebSubject;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.timeline.model.PO.User;
import com.timeline.support.annotation.UserLogin;
import com.timeline.support.annotation.UserLoginHolder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class ShiroInterceptor implements HandlerInterceptor {

  private static final Logger log = LoggerFactory.getLogger(ShiroInterceptor.class);

  private Map<Class<?>, UserLoginHolder> cache = Maps.newConcurrentMap();

  private WebSecurityManager webSecurityManager;

  private ServletContext servletContext;

  private Object object = new Object();

  public void setWebSecurityManager(WebSecurityManager webSecurityManager) {
    this.webSecurityManager = webSecurityManager;
    SecurityUtils.setSecurityManager(getSecurityManager());
  }

  @Override
  public boolean preHandle( final HttpServletRequest servletRequest,
                            final HttpServletResponse servletResponse,
                            final Object handler ) throws Exception {

    Throwable t = null;

    try {
      HandlerMethod handlerMethod = (HandlerMethod) handler;
      UserLoginHolder holder = getUserLoginHolder(handlerMethod);

      // wrap request and response
      final ServletRequest request = prepareServletRequest(servletRequest, servletResponse);
      final ServletResponse response = prepareServletResponse(request, servletResponse);

      // create subject
      final Subject subject = createSubject(request, response);

      // bind subject to current thread
      ThreadContext.bind(subject);

      // execute
      subject.execute(() -> {

        // update session
        updateSessionLastAccessTime(request, response);
        Method method = handlerMethod.getMethod();
        if (holder.needCheck(method)) {

          if (!subject.isAuthenticated()) {
            WebUtils.saveRequest(request);
            throw new RuntimeException("you need login");
          }
          request.setAttribute("userID", ((User) subject.getPrincipal()).getId());
        }
      });
    } catch (ExecutionException ex) {
      t = ex.getCause();
    } catch (Throwable throwable) {
      t = throwable;
    }

    if (t != null) {
      if (t instanceof ServletException) {
        throw (ServletException) t;
      }
      if (t instanceof IOException) {
        throw (IOException) t;
      }
      //otherwise it's not one of the two exceptions expected by the filter method signature - wrap it in one:
      String msg = "Filtered request failed.";
      throw new ServletException(msg, t);
    }

    return true;
  }

  private UserLoginHolder getUserLoginHolder(HandlerMethod handlerMethod) {
    UserLoginHolder holder = cache.get(handlerMethod.getBeanType());
    Class<?> type = handlerMethod.getBeanType();
    if (holder == null) {

      synchronized (type) {

        if (holder == null) {

          holder = processUserLogin(handlerMethod);
          cache.put(handlerMethod.getBeanType(), holder);
        }
      }
    }
    return holder;
  }

  private UserLoginHolder processUserLogin(HandlerMethod handlerMethod) {

    if (handlerMethod == null) {
      return null;
    }

    Class<?> classType = handlerMethod.getBeanType();
    UserLogin onType = classType.getAnnotation(UserLogin.class);
    if (onType != null) {
      return new UserLoginHolder(true, classType, onType.exclusive());
    }

    UserLoginHolder holder = new UserLoginHolder(false, classType, null);
    Method[] methods = classType.getDeclaredMethods();
    if (methods != null && methods.length > 0) {
      for (Method method : methods) {
        UserLogin onMethod = method.getAnnotation(UserLogin.class);
        if (onMethod != null) {
          holder.addMethod(method);
        }
      }
    }

    return holder;
  }

  protected WebSubject createSubject(ServletRequest request, ServletResponse response) {
    return new WebSubject.Builder(getSecurityManager(), request, response).buildWebSubject();
  }

  protected void updateSessionLastAccessTime(ServletRequest request, ServletResponse response) {
    if (!isHttpSessions()) { //'native' sessions
      Subject subject = SecurityUtils.getSubject();
      //Subject should never _ever_ be null, but just in case:
      if (subject != null) {
        Session session = subject.getSession(false);
        if (session != null) {
          try {
            session.touch();
          } catch (Throwable t) {
            log.error("session.touch() method invocation has failed.  Unable to update" +
                "the corresponding session's last access time based on the incoming request.", t);
          }
        }
      }
    }
  }

  protected boolean isHttpSessions() {
    return getSecurityManager().isHttpSessionMode();
  }

  public WebSecurityManager getSecurityManager() {
    return webSecurityManager;
  }

  protected ServletResponse prepareServletResponse(ServletRequest request, ServletResponse response) {
    ServletResponse toUse = response;
    if (!isHttpSessions() && (request instanceof ShiroHttpServletRequest) &&
        (response instanceof HttpServletResponse)) {
      //the ShiroHttpServletResponse exists to support URL rewriting for session ids.  This is only needed if
      //using Shiro sessions (i.e. not simple HttpSession based sessions):
      toUse = wrapServletResponse((HttpServletResponse) response, (ShiroHttpServletRequest) request);
    }
    return toUse;
  }

  protected ServletResponse wrapServletResponse(HttpServletResponse orig, ShiroHttpServletRequest request) {
    return new ShiroHttpServletResponse(orig, request.getServletContext(), request);
  }

  protected ServletRequest prepareServletRequest(ServletRequest request, ServletResponse response) {
    ServletRequest toUse = request;
    if (request instanceof HttpServletRequest) {
      HttpServletRequest http = (HttpServletRequest) request;
      toUse = wrapServletRequest(http);
    }
    return toUse;
  }

  protected ServletRequest wrapServletRequest(HttpServletRequest orig) {
    return new ShiroHttpServletRequest(orig, getServletContext(), isHttpSessions());
  }

  @Override
  public void postHandle( final HttpServletRequest request,
      final HttpServletResponse response,
      final Object handler,
      final ModelAndView modelAndView ) throws Exception {

  }

  @Override
  public void afterCompletion( final HttpServletRequest request,
      final HttpServletResponse response,
      final Object handler, final Exception ex ) throws Exception {

  }

  public ServletContext getServletContext() {
    return servletContext;
  }

  public void setServletContext(final ServletContext servletContext) {
    this.servletContext = servletContext;
  }
}
