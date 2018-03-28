package com.webservice.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.restfull.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
