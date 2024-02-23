package com.example.TastyTrove;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
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
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
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
		
		if(recipeChoice == 1) {
			recipeName = "northIndian";
		} else if(recipeChoice == 2) {
			recipeName = "southIndian";
		} else if(recipeChoice == 3) {
			recipeName = "chinese";
		} else {
			return;
		}
		
		
		String ingredientName = "";
		if(ingredientChoice == 1) {
			ingredientName = "Lentils";
		} else if (ingredientChoice == 2) {
			ingredientName = "Rice";
		} else if (ingredientChoice == 3) {
			ingredientName = "Wheat";
		} else {
			return;
		}
		
		Ingredients ingredient = (Ingredients) context.getBean(ingredientName.toLowerCase());
		ingredient.setIngredient(recipeName);
		Recipe recipe = (Recipe) context.getBean(recipeName+ingredientName);
		recipe.setUserName(userName);
		
		recipe.getDetails();
		
	}

}