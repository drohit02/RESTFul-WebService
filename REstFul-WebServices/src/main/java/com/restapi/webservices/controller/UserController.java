package com.restapi.webservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restapi.webservices.dto.UserDTO;
import com.restapi.webservices.models.User;
import com.restapi.webservices.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> findAllUsers() {
		List<User> users = this.userService.retriveAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> findUserusingId(@PathVariable Integer id){
		User userdb = this.userService.retriveUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(userdb);
		
	}
	@PostMapping("/users")
	public ResponseEntity<User> persistUser(@RequestBody UserDTO user) {
		/*
		 * 1. Created method to saved user 
		 * 2.first mapped the method with respective HTTP method i.e.POST 
		 * 3.Accept the data from request body and saved in UserDTO object 
		 * 4.Send this data or object to the dao to saved in database 
		 * 5.If the data saved properly in database it returns the saved object 
		 * 6.Saved object will be type of the User and the response is given back to User.
		 * 7.In the response location to check the saved data present for consumer
		 */

		User savedUser = this.userService.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
													.path("/{id}")
													.buildAndExpand(savedUser.getUseId())
													.toUri();
		return ResponseEntity.created(location).body(savedUser);

	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO) {
	    // Call the service layer to update the user
	    User updatedUser = this.userService.updateUser(id, userDTO);
	    return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
	    // Call the service layer to delete the user
	    this.userService.deleteUser(id);
	    return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
	}



}
