package com.restapi.webservices.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.webservices.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
