package com.tavisca.test.model.ingredients;

public class Soda extends Ingredient {

	private final double cost = 0.5;
	
	@Override
	public double getCost() {
		return cost;
	}

}
