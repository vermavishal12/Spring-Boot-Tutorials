package com.example.TuneIn;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class TuneInApplication {

    public static void main(String[] args) {

        /*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

		 Tasks:
		1. Fetch context from ApplicationContext.xml and initiate Scanner.
		2. Fetch User details from Console.
		3. Get the required bean from context.
		4. Get the songs from Console and add them to the playlist
		5. Display the playlist reference Id
		6. Display the list of songs with their reference Id
		 */
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.TuneIn");
//    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	
    	System.out.println("Welcome to Music Playlist Application");
    	System.out.println("What is your name?");
    	Scanner scanner = new Scanner(System.in);
    	
    	String name = scanner.nextLine();
    	System.out.println("What is your age?");
    	Scanner scannerB = new Scanner(System.in);
    	Integer age = scannerB.nextInt();
    	
    	//User myUser = (User) context.getBean("myUser");
    	User myUser = context.getBean(MyUser.class);
    	myUser.setUserDetail(name, age);
    	
    	while(true) {
    		
    		System.out.println("Do you want to add Songs to the playlist");
    		
    		System.out.println("1. Yes \n2. No");
    		int choice = scannerB.nextInt();
    		if(choice != 1)break;
    		
    		System.out.println("Enter name of the Song");
    		name = scanner.nextLine();
    		
    		Song mySong = context.getBean(MySong.class); 
    		//mySong = (Song) context.getBean("mySong");
    		mySong.setName(name);
    		Playlist myPlaylist = myUser.getPlaylist();
    		myPlaylist.addSong(mySong);
    	}
    	
    	Playlist myPlaylist = myUser.getPlaylist();
    	String str[] = myPlaylist.toString().split("@");
    	System.out.println("Your Playlist with reference Id: @" + str[1] + " is Ready!!");
    	
    	Integer count = myPlaylist.getCount();
    	List<Song> songList = myPlaylist.getPlaylistSongs();

    	for(Integer i = 0 ; i < count ; i++) {
    		Song song = songList.get(i);
    		String parts[] = song.toString().split("@");
    		System.out.println("Song name: " + song.getSongName() + "\tReference Id: @" + parts[1]);
    	}
    	
    	scanner.close();
    	scannerB.close();
    	context.close();
    }

}
