package com.anamikash.socialMedia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer id;
	
	//@Size(min = 10)
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	//@JsonIgnore
	private User user;
}
