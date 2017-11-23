package com.timeline.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.timeline.model.DTO.UserDTO;
import com.timeline.model.PO.User;
import com.timeline.service.UserService;
import com.timeline.util.ConvertUtils;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
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
	
	public UserDTO login(@RequestParam("userName")String userName, 
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
}
