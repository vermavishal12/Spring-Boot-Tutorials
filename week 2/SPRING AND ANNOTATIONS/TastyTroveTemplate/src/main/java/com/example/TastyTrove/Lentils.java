package com.example.TastyTrove;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

/*
  This class is an implementation of a Ingredients Interface based on the selection 
  done in the console for the ingredient.You need to complete this class based on
  the following tasks.
    
    Tasks:
        1. Override the methods of Ingredients Interface.
        2. Create the constructor for this class and add your choice of ingredients in the list based on
           the type of recipe for example

                  public Lentils() {
                    Collections.addAll(southIndianRiceRecipes, "Rice", "Salt", "Black Gram");
                    }
 */
@Component("lentils")
public class Lentils implements Ingredients {

 /** Given below are the 3 booleans based on the recipe type.These booleans bydefault will be false however
    based on recipe type selected ( setIngredient(String ingredient) ) this boolean will become true accordingly.
 **/
    
    private boolean isChinese = false;
    private boolean isNorthIndian = false;
    private boolean isSouthIndian = false;

 /** Given below are 3 ArrayList which are used to store the ingredients of your choice based 
     on the recipe type.Refer to point number 2 above.
 **/   
    
    private List<String> chineseLentilsRecipes = new ArrayList<String>();
    private List<String> northIndianLentilsRecipes = new ArrayList<String>();
    private List<String> southIndianLentilsRecipes = new ArrayList<String>();

    public Lentils() {
    	Collections.addAll(southIndianLentilsRecipes, "batter", "Salt", "Blac Gram");
    	Collections.addAll(northIndianLentilsRecipes, "Salt", "Onion", "Garlic");
    	Collections.addAll(chineseLentilsRecipes, "Boiled Noodles", "Schezwan Sauce", "Garlic");
    }

	@Override
	public void setIngredient(String ingredient) {
		if(ingredient.equalsIgnoreCase("Chinese")) {
			this.isChinese = true;
		}
		else if(ingredient.equalsIgnoreCase("NorthIndian")){
			this.isNorthIndian =true;
		} else if(ingredient.equalsIgnoreCase("SouthIndian")) {
			this.isSouthIndian = true;
		}
		
	}

	@Override
	public String getDishDetail() {
		if(this.isNorthIndian) {
			return "Paratha";
		} else if(this.isSouthIndian) {
			return "Dosa";
		} else if(this.isChinese) {
			return "Noodles";
		} else {
			return "";
		}
	}

	@Override
	public List<String> getIngredientsDetail() {
		if(this.isNorthIndian) {
			return this.northIndianLentilsRecipes;
		} else if(this.isSouthIndian) {
			return this.southIndianLentilsRecipes;
		} else if(this.isChinese) {
			return this.chineseLentilsRecipes;
		} else {
			return this.chineseLentilsRecipes;
		}
	}


}
