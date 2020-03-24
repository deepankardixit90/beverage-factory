package com.tavisca.test.model.ingredients;

public class IngredientFactory {
	
	   public Ingredient getIngredient(String ingredient){
		   
	      if(ingredient == null){
	         return null;
	      }			      
	      if(ingredient.equalsIgnoreCase("MILK")) {
	         return new Milk();	         
	      } else if(ingredient.equalsIgnoreCase("MINT")) {
	         return new Mint();	         
	      } else if(ingredient.equalsIgnoreCase("SODA")) {
	         return new Soda();	         
	      } else if(ingredient.equalsIgnoreCase("SUGAR")) {
		     return new Sugar();		     
		  } else if(ingredient.equalsIgnoreCase("WATER")) {
			     return new Water();
		  }	      
	      return null;
	   }

}
