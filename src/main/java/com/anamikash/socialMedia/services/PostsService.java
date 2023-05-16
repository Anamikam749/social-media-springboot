package com.anamikash.socialMedia.services;

import java.util.List;

import com.anamikash.socialMedia.entities.Post;

public interface PostsService {

	List<Post> getAllPostsByUser(Integer userId);

	Post createPost(Integer userId, Post postRequestBody);

	Post getPostByPostId(Integer userId, Integer postId);
	
	

}
