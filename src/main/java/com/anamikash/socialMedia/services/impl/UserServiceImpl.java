package com.anamikash.socialMedia.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anamikash.socialMedia.entities.User;
import com.anamikash.socialMedia.repository.UserRepository;
import com.anamikash.socialMedia.services.UserService;

import lombok.AllArgsConstructor;

//@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	 private UserRepository userRepository;
	 
//	 private PostRepository postRepository;

	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) {
		
		return userRepository.save(user);
		
		
	}

	@Override
	public User getUserById(Integer userId) {
		return userRepository.findById(userId).orElse(null);
	}

}
