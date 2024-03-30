package com.CN.Gym.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 425126575075545843L;

	/*
        Extend the class with RuntimeException and create a constructor with
        (String message) as argument in order to handle custom exception message.
    */
	public UserNotFoundException(String message) {
		super(message);
	}
}
