package com.anamikash.socialMedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anamikash.socialMedia.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
}
