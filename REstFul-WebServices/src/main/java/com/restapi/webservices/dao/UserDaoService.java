package com.restapi.webservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.webservices.customexception.UserNotFoundException;
import com.restapi.webservices.dto.UserDTO;
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

	@Override
	public User saveUser(UserDTO user) {
		User newUser = new User(user.getUserName(),user.getBirthDate());
		User savedUser = new User();
		try {
		 savedUser = this.userRepository.save(newUser);
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return savedUser;
	}

	@Override
	public User retriveUserById(Integer id) {
		Optional<User> savedUser = this.userRepository.findById(id);
		if(!savedUser.isPresent())
			throw new UserNotFoundException("User not found with id : "+id);
		return savedUser.get();
	}

}
