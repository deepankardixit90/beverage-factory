package com.tavisca.test.model.beverages;

import java.util.List;

import com.tavisca.test.model.ingredients.Ingredient;

public abstract class Beverage {
	
	public abstract double getCost();
	
	public abstract List<Ingredient> getIngredients();
	
	public abstract String getBeverageName();

}
