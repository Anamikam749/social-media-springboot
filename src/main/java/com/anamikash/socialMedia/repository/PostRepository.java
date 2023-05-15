package com.anamikash.socialMedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anamikash.socialMedia.entities.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
