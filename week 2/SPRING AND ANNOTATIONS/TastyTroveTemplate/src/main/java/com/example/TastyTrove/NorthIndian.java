package com.example.TastyTrove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 
  This class is an implementation of a Recipe Interface based on the selection 
  done in the console for Recipe type.You need to complete this class 
  based on the following tasks.
   
    Tasks:
  a. Override the methods of Recipe Interface.
  b. Add common attributes:
      1. String name
      2. String userName
      3. Ingredients ingredients
  c. Build the logic for all the methods based on the description mentioned in the Recipe Interface.
  d. Create a setter injection mentioned named as "setIngredients(Ingredients ingredients)" this method 
     injects the "ingredient" attribute as  a dependency into this class using Setter Injection approach.
     
**/
@Component("northIndian")
public class NorthIndian implements Recipe {

	private String name;
	private String userName;
	private Ingredients ingredients;
	
	@Autowired
	@Qualifier("wheat")
	private Ingredients wheatIngredients;
	
	@Autowired
	@Qualifier("rice")
	private Ingredients riceIngredients;
	
	@Autowired
	@Qualifier("lentils")
	private Ingredients lentilsIngredients;
	
	
	public void setIngredients(Ingredients ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public void getDetails() {
		this.name = this.ingredients.getDishDetail();
		System.out.println("Hello user " + this.userName + " we suggest you to make " + this.name + " you can use the following ingredients:");
		int count = 1;
		for(String ing : this.ingredients.getIngredientsDetail()) {
			System.out.println( count + ". " +ing);
			count++;
		}
	}

	@Override
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		this.userName = userName;
		
	}

	@Override
	public void setIngredients(String ingredients) {
		if(ingredients == "wheat") {
			this.ingredients = this.wheatIngredients;
			
		} else if(ingredients == "rice") {
			this.ingredients = this.riceIngredients;
			
		} else if(ingredients == "lentils") {
			this.ingredients = this.lentilsIngredients;
		}else {
			
		}
		
		this.ingredients.setIngredient("northIndian");
		
	}

}
