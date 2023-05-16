package com.anamikash.socialMedia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anamikash.socialMedia.entities.Post;
import com.anamikash.socialMedia.exceptions.PostNotFoundException;
import com.anamikash.socialMedia.exceptions.UserNotFoundException;
import com.anamikash.socialMedia.repository.PostRepository;
import com.anamikash.socialMedia.repository.UserRepository;
import com.anamikash.socialMedia.services.PostsService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class PostsServiceImpl implements PostsService {
	
	private UserRepository userRepository;
	private PostRepository postRepository;

	@Override
	public List<Post> getAllPostsByUser(Integer userId) {
		
		Boolean doesUserExists=userRepository.existsById(userId);
		
		if(!doesUserExists) {
			throw new UserNotFoundException("User Does Not Exists For Id : " + userId);
		}
		
		return postRepository.findByUser(userRepository.findById(userId).get());
	}

	@Override
	public Post createPost(Integer userId, Post postRequestBody) {
		boolean doesUserExists= userRepository.existsById(userId);
		if(!doesUserExists) {
			throw new UserNotFoundException("User Does Not Exists For Id : " + userId);
		}
		postRequestBody.setUser(userRepository.findById(userId).get());
		Post postCreated =postRepository.save(postRequestBody);
		
		return postCreated;
	}

	@Override
	public Post getPostByPostId(Integer userId, Integer postId) {
		
		List<Post>  allPostsList=getAllPostsByUser(userId);
		Post post=  allPostsList.stream().filter(p->p.getId()==postId).findFirst().orElseThrow(()-> new PostNotFoundException("Post not found with post id:" +postId));
		return post;
	}

}
