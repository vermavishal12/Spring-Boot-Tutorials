package com.example.TuneIn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
  This class is an implementation of a "Playlist" Interface.This class is injected as a dependency 
  in MyUser class.You need to complete this class based on the following tasks.
    
   Tasks:
   a. Adding common attributes: 
      1. Integer count
      2. Song mySong  (Interface inject through setter injection)
      3. List<Song> songsList
   b. Override the methods of Playlist Interface.
   c. Create a method named "setMySong (Song mySong)", this method sets the value of the "mySong"
      attribute using the setter injection approach.
   d.Build the logic for all the methods based on the description mentioned in the Playlist Interface.

**/

@Component("myPlaylist")
public class MyPlaylist implements Playlist {

	Integer count = 0;
	
	@Autowired
	@Qualifier("mySong")
	Song mySong;
	
	ArrayList<Song> songList;
	
	public void setMySong(Song mySong) {
		this.mySong = mySong;
	}
	
	
	@Override
	public void addSong(Song song) {
		if(songList == null) {
			this.songList = new ArrayList<Song> ();
		}
		
		this.songList.add(song);
		this.setMySong(song);
		count++;
	}

	@Override
	public List<Song> getPlaylistSongs() {
		return this.songList;
	}

	@Override
	public Integer getCount() {
		return this.count;
	}

}