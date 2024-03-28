package com.example.TuneIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
  This class is an implementation of a User Interface based on the selection 
  done in the console for user information.You need to complete this class 
  based on the following tasks.
    
   Tasks:
   a. Adding common attributes: 
       1. String name
       2. Integer age
       3. Playlist playlist (Interface inject through setter injection)
   b. Override the methods of User Interface.
   c. Create a method named "setPlaylist(Playlist playlist)", this method sets the value of the "playlist"
      attribute using the setter injection approach.
   d.Build the logic for all the methods based on the description mentioned in the User Interface.

**/

@Component("myUser")
public class MyUser implements User {

	String name;
	
	Integer age;
	
	@Autowired
	@Qualifier("myPlaylist")
	Playlist playlist;
	
	
	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	@Override
	public void setUserDetail(String name, Integer age) {
		this.name = name;
		this.age = age;
		
	}

	@Override
	public Playlist getPlaylist() {
		return this.playlist;
	}

}
