package com.webservice.restfull.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.webservice.restfull.model.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int countId = 3;
	
	static {
		users.add(new User(1, "Daniel", new Date()));
		users.add(new User(2, "José", new Date()));
		users.add(new User(3, "Maria", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++countId);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user:users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
}
