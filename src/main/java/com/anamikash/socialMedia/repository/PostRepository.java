package com.anamikash.socialMedia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anamikash.socialMedia.entities.Post;
import com.anamikash.socialMedia.entities.User;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);

	

	
}
