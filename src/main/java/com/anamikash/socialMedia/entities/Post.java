package com.anamikash.socialMedia.entities;

import javax.sound.midi.Sequence;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Post {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	private Integer id;
	
	//@Size(min = 10)
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private User user;
}
