package com.restapi.webservices.service;

import java.util.List;

import com.restapi.webservices.dto.UserDTO;
import com.restapi.webservices.models.User;

public interface UserService {

	List<User> retriveAllUsers();
	User saveUser(UserDTO user);
	User retriveUserById(Integer id);
	User updateUser(Integer userId, UserDTO userDTO);
	void deleteUser(Integer userId);
}