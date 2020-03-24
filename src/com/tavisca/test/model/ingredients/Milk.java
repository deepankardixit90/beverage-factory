package com.tavisca.test.model.ingredients;

public class Milk extends Ingredient {
	
	private final double cost = 1;

	@Override
	public double getCost() {
		return cost;
	}

}
