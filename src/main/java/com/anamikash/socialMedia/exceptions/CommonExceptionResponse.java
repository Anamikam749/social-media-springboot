package com.anamikash.socialMedia.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommonExceptionResponse {
	
	private LocalDateTime timestamp;
	private String message;
	private String details;

}
