package com.example.TastyTrove;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
  This class is an implementation of a Ingredients Interface based on the selection 
  done in the console for the ingredient.You need to complete this class based on
  the following tasks.
    
    Tasks:
        1. Override the methods of Ingredients Interface.
        2. Create the constructor for this class and add your choice of ingredients in the list based on
           the type of recipe for example

                  public Rice() {
                    Collections.addAll(southIndianRiceRecipes, "Rice", "Salt", "Black Gram");
                    }
 */


public class Rice implements Ingredients {
  
  /** Given below are the 3 booleans based on the recipe type.These booleans bydefault will be false however
    based on recipe type selected ( setIngredient(String ingredient) ) this boolean will become true accordingly.
  **/

    private boolean isChinese;
    private boolean isNorthIndian;
    private boolean isSouthIndian;

 /** Given below are 3 ArrayList which are used to store the ingredients of your choice based 
     on the recipe type.Refer to point number 2 above.
 **/
    private List<String> chineseRiceRecipes = new ArrayList<String>();
    private List<String> northIndianRiceRecipes = new ArrayList<String>();
    private List<String> southIndianRiceRecipes = new ArrayList<String>();
	
    public Rice() {
    	Collections.addAll(northIndianRiceRecipes, "Boiled Rice", "Salt","Clover");
    	Collections.addAll(southIndianRiceRecipes, "Boiled Rice", "Salt", "Honey");
    	Collections.addAll(chineseRiceRecipes, "Boiled Rice", "Schezwan Saurce", "Hot Sauce");
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
			return "Biryani";
		} else if(this.isSouthIndian) {
			return "Idli";
		} else if(this.isChinese) {
			return "Fried Rice";
		} else {
			return "";
		}
	}
	@Override
	public List<String> getIngredientsDetail() {
		if(this.isNorthIndian) {
			return this.northIndianRiceRecipes;
		} else if(this.isSouthIndian) {
			return this.southIndianRiceRecipes;
		} else if(this.isChinese) {
			return this.chineseRiceRecipes;
		} else {
			return this.chineseRiceRecipes;
		}
	}



}
