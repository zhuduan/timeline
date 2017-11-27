package com.timeline.service.impl;

import com.timeline.model.DTO.UserDTO;
import com.timeline.model.PO.User;
import com.timeline.repository.UserDAO;
import com.timeline.service.UserService;
import com.timeline.util.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public int register(UserDTO user) throws Exception {

		User existsUser = getUserByName(user.getName());
		if(existsUser != null && existsUser.getName().equals(user.getName())) {
			
			throw new Exception("user name exists!");
		}
		
		existsUser = ConvertUtils.convert(user, User.class);
		
		return userDAO.insertUser(existsUser);
	}

	@Override
	public int insertUser(User user) {

		return userDAO.insertUser(user);
	}

	@Override
	public User getUserByID(Long id) {

		return userDAO.getUserByID(id);
	}

	@Override
	public User getUserByName(String name) {

		return userDAO.getUserByName(name);
	}

	@Override
	public User login(UserDTO user) throws Exception {

		User existsUser = userDAO.getUserByName(user.getName());
		if(existsUser != null && existsUser.getPassword().equals(user.getPassword())) {
			
			return existsUser;
		} else {
			
			throw new Exception("user not exist or password invalid");
		}
	}

}
