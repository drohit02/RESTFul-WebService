package com.restapi.webservices.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.webservices.models.User;
import com.restapi.webservices.repository.UserRepository;
import com.restapi.webservices.service.UserService;

@Service
public class UserDaoService implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> retriveAllUsers() {
		List<User> users = this.userRepository.findAll();
		try {
			if (users.isEmpty())
				throw new RuntimeException("No user found");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return users;
	}

}
