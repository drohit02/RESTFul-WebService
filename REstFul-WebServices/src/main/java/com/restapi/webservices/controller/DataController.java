package com.restapi.webservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.webservices.service.DataService;

@RestController
public class DataController {
	
	@Autowired
	private DataService dataService;
	
	@GetMapping("/")
	public ResponseEntity<String> homepage() {
		return ResponseEntity.status(HttpStatus.OK).body("Welcome to RESTFul Web-Service by SpringBoot");
	}

}
