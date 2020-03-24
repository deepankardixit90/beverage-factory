package com.tavisca.test.model.beverages;


public class BeverageFactory {

	public Beverage getBeverage(String beverage){
		   
	      if(beverage == null){
	    	  return null;
	      }			      
	      if(beverage.equalsIgnoreCase("CHAI")) {
	         return new Chai();	         
	      } else if(beverage.equalsIgnoreCase("COFFEE")) {
	         return new Coffee();         
	      } else if(beverage.equalsIgnoreCase("MOJITO")) {
	         return new Mojito();	         
	      } else if(beverage.equalsIgnoreCase("STRAWBERRYSHAKE")) {
		     return new StrawberryShake();	     
		  } else if(beverage.equalsIgnoreCase("BANANASMOOTHIE")) {
			 return new BananaSmoothie();
		  }	      
	      return null;
	   }
}
