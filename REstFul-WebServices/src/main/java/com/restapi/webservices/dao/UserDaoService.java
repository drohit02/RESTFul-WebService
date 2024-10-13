package com.restapi.webservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.webservices.customexception.ApiException;
import com.restapi.webservices.customexception.ResourceNotFoundException;
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
			if (users.isEmpty())
				throw new RuntimeException("No user found");
		return users;
	}

	@Override
	public User saveUser(UserDTO user) {
	    try {
	        User newUser = new User(user.getUserName(), user.getBirthDate());
	        User savedUser = this.userRepository.save(newUser);
	        return savedUser;
	    } catch (Exception e) {
	        throw new ApiException("Error occurred while saving user: " + e.getMessage());
	    }
	}
	@Override
	public User retriveUserById(Integer id) {
		Optional<User> savedUser = this.userRepository.findById(id);
		if(!savedUser.isPresent())
			throw new UserNotFoundException("User not found with id : "+id);
		return savedUser.get();
	}

	@Override
	public User updateUser(Integer userId, UserDTO userDTO) {
	    // Check if the user exists in the database
	    User existingUser = this.userRepository.findById(userId)
	        .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

	    // Update the user's details
	    existingUser.setUserName(userDTO.getUserName());
	    existingUser.setBirthDate(userDTO.getBirthDate());
	    
	    // Save the updated user back to the database
	    return userRepository.save(existingUser);
	}
	
	@Override
	public void deleteUser(Integer userId) {
	    // Check if the user exists in the database
	    User existingUser = userRepository.findById(userId)
	        .orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + userId));
	    
	    // Delete the user
	    this.userRepository.delete(existingUser);
	}


}
