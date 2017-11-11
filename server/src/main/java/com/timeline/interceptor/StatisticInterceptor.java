package com.timeline.interceptor;

import com.timeline.service.StatisticInfoService;
import com.timeline.service.impl.StatisticInfoServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class StatisticInterceptor implements HandlerInterceptor {

    @Autowired
    private StatisticInfoService statisticInfoService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // currently always use the default ID, for no login info now
        // TODO: fill the userID with params from request
        Integer userID = 0;

        statisticInfoService.saveInfo(httpServletRequest.getRequestURI(), userID, httpServletRequest.getRemoteAddr());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // do nothing, for now
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        // do nothing, for now
    }
}
