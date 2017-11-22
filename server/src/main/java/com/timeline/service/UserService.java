package com.timeline.service;

import com.timeline.model.DTO.UserDTO;
import com.timeline.model.PO.User;

public interface UserService {

	int register(UserDTO user) throws Exception;
	
	int insertUser(User user);
	
	User getUserByID(Long id);
	
	User getUserByName(String name);
}
