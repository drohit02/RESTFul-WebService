package com.restapi.webservices.dto;

import java.time.LocalDate; 

public class UserDTO {
	
	private String userName;
	private LocalDate birthDate;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String userName, LocalDate birthDate) {
		this.userName = userName;
		this.birthDate = birthDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
}
