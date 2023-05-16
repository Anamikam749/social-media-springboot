package com.anamikash.socialMedia.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anamikash.socialMedia.entities.Post;
import com.anamikash.socialMedia.services.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PostsController {
	
	private PostsService postsService;
	

	
	@GetMapping("users/{userId}/posts")
	public ResponseEntity<List<Post>> getAllPostsByUser(@PathVariable Integer userId){
		
		List<Post> postsByUserList = postsService.getAllPostsByUser(userId);
		//return ResponseEntity.ok(postsByUserList);
		return new ResponseEntity<List<Post>>(postsByUserList, HttpStatus.OK);	
	}
	
	@PostMapping("users/{userId}/posts")
	public ResponseEntity<URI> createPost( @RequestBody Post postRequestBody, @PathVariable Integer userId)
	{
		Post postCreated= postsService.createPost(userId, postRequestBody);
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(postCreated.getId())
                .toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@GetMapping("users/{userId}/posts/{postId}")
	public  ResponseEntity<Post> getPostByPostId(@PathVariable Integer userId, @PathVariable Integer postId){
		 Post post = postsService.getPostByPostId(userId, postId);
		 return ResponseEntity.ok(post);
		
	}
}
