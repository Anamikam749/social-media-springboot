package com.anamikash.socialMedia.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anamikash.socialMedia.entities.User;
import com.anamikash.socialMedia.exceptions.UserNotFoundException;
import com.anamikash.socialMedia.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController{
	
	
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> usersList = userService.getAllUser() ;
		
		return ResponseEntity.ok(usersList);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer userId)
	{
		User user = userService.getUserById(userId);
		
		/*
		 * if(user==null) { throw new UserNotFoundException("User with Id :" + userId +
		 * " does not exist "); }
		 */
		return ResponseEntity.ok(user);
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<URI> createUser(@RequestBody User user){
		User savedUser = userService.createUser(user);
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
		return ResponseEntity.created(location).build();
	}
}
