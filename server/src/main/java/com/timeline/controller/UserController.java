package com.timeline.controller;

import com.google.common.collect.Maps;
import com.timeline.common.ControllerException;
import com.timeline.common.ErrorType;
import com.timeline.common.ResponseUtils;
import com.timeline.model.DTO.UserDTO;
import com.timeline.model.PO.User;
import com.timeline.service.UserService;
import com.timeline.util.ConvertUtils;
import com.timeline.util.LogUtil;
import com.timeline.util.NumberUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Api(description = "user related api")
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public UserDTO register(@RequestParam("userName") String userName,
							@RequestParam("password") String password,
							@RequestParam("email") String email,
							@RequestParam("phone") String phone) throws Exception {

		if (StringUtils.isAnyEmpty(userName, password, email, phone)) {

			throw new Exception("parameter is null");
		}

		UserDTO user = new UserDTO();
		user.setName(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);

		if (userService.register(user) > 0) {

			return user;
		} else {

			throw new Exception("register failure");
		}
	}

	@RequestMapping(value = "login", method = {RequestMethod.GET, RequestMethod.POST})
	public Object login(ServletRequest request, String userName, String password) throws Exception {

		String requestMethod = ((HttpServletRequest) request).getMethod();
		if (requestMethod.equalsIgnoreCase(RequestMethod.GET.name())) {

			Map<String, Object> loginInfo = Maps.newHashMap();
			loginInfo.put("loginURL", "/user/login");
			loginInfo.put("msg", "you need login!");
			return ResponseUtils.toFailure(loginInfo, ResponseUtils.NeedLoginStatus);
		}

		if (StringUtils.isAnyEmpty(userName, password)) {

			throw new Exception("parameter is null");
		}
		try {

			doLogin(userName, password);
			UserDTO dto = new UserDTO();
			dto.setName(userName);
			dto.setPassword(password);
			User user = userService.login(dto);
			return ResponseUtils.toSuccess(ConvertUtils.convert(user, UserDTO.class));

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 登录路径下不经过shiro的filter处理
	 * 由controller处理登录过程，以便处理各种异常
	 * 如果经过shiro的filter处理，则由request传递异常
	 */
	private void doLogin(String username, String password) {

		UsernamePasswordToken token = new UsernamePasswordToken();
		token.setUsername(username);
		token.setPassword(password.toCharArray());

		//get current subject
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
	}


	@ApiOperation(httpMethod = "GET", value = "get user info detail by ID", response = Map.class)
	@RequestMapping(value = "info", method = {RequestMethod.GET})
	public Map<String, Object> getUserInfo(@RequestParam("userID") Integer userID) throws Exception {
		if ( !NumberUtil.isPositiveAndValid(userID) ) {
			LogUtil.appLog.info(LogUtil.getMsg("wrong input for: userID="+userID));
			throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
		}
		
		UserDTO userInfo = ConvertUtils.convert(userService.getUserByID(userID) , UserDTO.class);
		return ResponseUtils.toSuccess(userInfo);
	}
}
