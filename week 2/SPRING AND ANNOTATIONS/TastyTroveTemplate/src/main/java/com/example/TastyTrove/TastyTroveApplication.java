package com.example.TastyTrove;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class TastyTroveApplication {

	public static void main(String[] args) {
		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.
		
		1. Fetch context from ApplicationContext.xml and initiate Scanner
		2. Fetch User details from Console
		3. Fetch Recipe selection from User
		4. Fetch Ingredient Selection
		5. Get the required bean from context.
		6. Set user's name and display the recipe details
		 */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.TastyTrove");
		System.out.println("Welcome to Tasty Trove Application");
		
		System.out.println("Enter your name?");
		Scanner scanner = new Scanner(System.in);
		String userName = scanner.nextLine();
		
		
		System.out.println("Select Recipe: \n1. North Indian \n2. South Indian \n3. Chinese");
		Scanner scannerInt = new Scanner(System.in);
		int recipeChoice = scannerInt.nextInt();
		
		System.out.println("Select Ingredient: \n1. Lentils \n2. Rice \n3. Wheat");
		int ingredientChoice = scannerInt.nextInt();
		
		String recipeName = "";
		Recipe recipe;
		if(recipeChoice == 1) {
			recipeName = "northIndian";
			recipe = context.getBean(NorthIndian.class);
		} else if(recipeChoice == 2) {
			recipeName = "southIndian";
			recipe = context.getBean(SouthIndian.class);
		} else if(recipeChoice == 3) {
			recipeName = "chinese";
			recipe = context.getBean(Chinese.class);
		} else {
			return;
		}
		
		
		String ingredientName = "";
		if(ingredientChoice == 1) {
			ingredientName = "lentils";
		} else if (ingredientChoice == 2) {
			ingredientName = "rice";
		} else if (ingredientChoice == 3) {
			ingredientName = "wheat";
		} else {
			return;
		}
		
		
		
		
		recipe.setUserName(userName);
		recipe.setIngredients(ingredientName);
		
		recipe.setIngredients(ingredientName);
	
		
		recipe.getDetails();
		scanner.close();
		scannerInt.close();
		
	}

}