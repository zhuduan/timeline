package com.timeline.service;

import com.timeline.model.DTO.UserDTO;
import com.timeline.model.PO.User;
import com.timeline.support.common.EnumAction;

public interface UserService {

  int register(UserDTO user) throws Exception;

  User login(UserDTO user) throws Exception;

  int insertUser(User user);

  User getUserByID(Integer id);

  User getUserByName(String name);

  Boolean isAuthorised(Integer userID, EnumAction action);
}
