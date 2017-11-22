package com.timeline.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.timeline.model.DTO.UserDTO;

@RestController
@RequestMapping("user")
public class UserController {

	public UserDTO register(@RequestParam("userName")String userName, 
							@RequestParam("password")String password,
							@RequestParam("email")String email,
							@RequestParam("phone")String phone) {
		
		return null;
	}
}
