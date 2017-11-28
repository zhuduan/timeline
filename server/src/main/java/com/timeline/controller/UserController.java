package com.timeline.controller;

import com.timeline.model.DTO.UserDTO;
import com.timeline.model.PO.User;
import com.timeline.service.UserService;
import com.timeline.util.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping( value = "register", method = RequestMethod.POST )
	public UserDTO register(@RequestParam("userName")String userName, 
							@RequestParam("password")String password,
							@RequestParam("email")String email,
							@RequestParam("phone")String phone) throws Exception {
		
		if(StringUtils.isAnyEmpty(userName, password, email, phone)) {
			
			throw new Exception("parameter is null");
		}
		
		UserDTO user = new UserDTO();
		user.setName(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		
		if(userService.register(user) > 0) {
			
			return user;
		} else {
			
			throw new Exception("register failure");
		}
	}

	@RequestMapping( value = "login", method = {RequestMethod.POST} )
	public UserDTO login( @RequestParam("userName")String userName,
						 @RequestParam("password")String password) throws Exception {

		if(StringUtils.isAnyEmpty(userName, password)) {
			
			throw new Exception("parameter is null");
		}
		
		UserDTO dto = new UserDTO();
		dto.setName(userName);
		dto.setPassword(password);
		
		User user = userService.login(dto);
		
		return ConvertUtils.convert(user, UserDTO.class);
	}

	@RequestMapping( value = "login/error", method = RequestMethod.GET )
	public String loginError() throws Exception {

		return "you need login!";
	}

	@RequestMapping( value = "info", method = RequestMethod.GET )
	public UserDTO info() {

		return new UserDTO();
	}
}
