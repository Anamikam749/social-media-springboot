package com.anamikash.socialMedia.responsemodel;

import java.time.LocalDate;
import java.util.List;

import com.anamikash.socialMedia.entities.Post;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

public class UserResponseModel {

	private String name;
	private LocalDate birthDate;
	private List<PostResponseModel> posts;
}
