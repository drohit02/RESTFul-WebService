package com.restapi.webservices.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer useId;
	private String userName;
	private LocalDate birthDate;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer useId, String userName, LocalDate birthDate) {
		super();
		this.useId = useId;
		this.userName = userName;
		this.birthDate = birthDate;
	}
	
	public User(String userName, LocalDate birthDate) {
		this.userName = userName;
		this.birthDate = birthDate;
	}

	public Integer getUseId() {
		return this.useId;
	}

	public void setUseId(Integer useId) {
		this.useId = useId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

}
