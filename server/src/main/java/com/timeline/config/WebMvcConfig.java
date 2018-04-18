package com.timeline.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.timeline.interceptor.StatisticInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Autowired
  @Qualifier("shiroInterceptor")
  private HandlerInterceptor shiroInterceptor;

  @Bean
  StatisticInterceptor statisticInterceptor() {
    // 如果拦截器里面需要使用到IOC里面的东西，这里需要声明成Bean来提供自动扫描
    // 并且对应的拦截器里面也需要加入@Component来标识
    return new StatisticInterceptor();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 拦截除了user接口外的所有接口，用于统计访问信息
    //      addPathPatterns 用于添加拦截规则, excludePathPatterns 用户排除拦截
    registry.addInterceptor(shiroInterceptor).addPathPatterns("/**");
    registry.addInterceptor(statisticInterceptor()).excludePathPatterns("/user/**");
    super.addInterceptors(registry);
  }
}
