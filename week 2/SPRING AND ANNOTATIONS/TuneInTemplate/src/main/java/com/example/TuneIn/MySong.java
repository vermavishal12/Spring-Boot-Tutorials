package com.example.TuneIn;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
  This class is an implementation of a "Song" Interface.This class is injected as a dependency 
  in MyPlaylist class. You need to complete this class based on the following tasks.
    
   Tasks:
   a. Add attribute name(String) 
   b. Override the methods of Song Interface.
   c. Build the logic for all the methods based on the description mentioned in the Playlist Interface.

**/

@Component("mySong")
@Scope("prototype")
public class MySong implements Song {

	String name;
	
	@Override
	public String getSongName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	

}
