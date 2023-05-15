package com.anamikash.socialMedia.services;

import java.util.List;

import com.anamikash.socialMedia.entities.User;

public interface UserService {
	
	public List<User> getAllUser();

	public User createUser(User user);

	public User getUserById(Integer userId);

}
