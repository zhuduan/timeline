package com.timeline.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Maps;
import com.timeline.model.PO.User;
import com.timeline.service.UserService;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import java.util.Arrays;
import java.util.Map;

@Configuration
public class ShiroFilterConfig {

  @Autowired
  private UserService userService;

  @Bean
  @Autowired
  @Qualifier("shiroFilter")
  public FilterRegistrationBean getShiroDelegateFilter(Filter shiroFilter) {

    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST,
        DispatcherType.INCLUDE,
        DispatcherType.FORWARD);
    filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
    filterRegistrationBean.setOrder(1);
    filterRegistrationBean.setFilter(shiroFilter);
    return filterRegistrationBean;
  }

  @Bean("shiroFilter")
  public ShiroFilterFactoryBean getShiroFilter() {

    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    shiroFilterFactoryBean.setFilterChainDefinitionMap(getFilterChainDefinitionMap());

    shiroFilterFactoryBean.setLoginUrl("/user/login");
    shiroFilterFactoryBean.setSecurityManager(getDefaultSecurityManager());
    return shiroFilterFactoryBean;
  }

  public Map<String, String> getFilterChainDefinitionMap() {

    Map<String, String> definitionMap = Maps.newLinkedHashMap();
    definitionMap.put("/user/login", DefaultFilter.anon.name());
    definitionMap.put("/user/login/error", DefaultFilter.anon.name());
    definitionMap.put("/user/register", DefaultFilter.anon.name());
    definitionMap.put("/user/**", DefaultFilter.authc.name());
    definitionMap.put("/**", DefaultFilter.anon.name());
    return definitionMap;
  }

  public DefaultSecurityManager getDefaultSecurityManager() {

    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(getRealm());
    return securityManager;
  }

  public Realm getRealm() {

    Realm realm = new AuthorizingRealm() {

      //为当前登录成功的用户授予权限和角色，已经登录成功了。
      protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
      }

      //验证当前登录的用户，获取认证信息。
      protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
          throws AuthenticationException {

        UsernamePasswordToken usertoken = (UsernamePasswordToken) token;

        String username = usertoken.getUsername();

        // check user input
        if (StringUtils.isEmpty(username)) {
          throw new AuthenticationException("Username must not be empty!");
        }

        // check user password
        if (usertoken.getPassword() == null || usertoken.getPassword().length == 0) {
          throw new AuthenticationException("Password must not be empty!");
        }

        User user = userService.getUserByName(username);

        // not found user
        if (user == null) {
          throw new UnknownAccountException("Username or Password is invalid!");
        }

        if (!String.valueOf(usertoken.getPassword()).equals(user.getPassword())) {
          throw new UnknownAccountException("Password Error!");
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
            user, //用户
            user.getPassword(), //密码
            null,//salt=username+salt
            getName()  //realm name
        );

        return authenticationInfo;
      }
    };

    return realm;
  }
}
