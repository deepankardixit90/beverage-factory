package com.tavisca.test.model.beverages;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.tavisca.test.model.ingredients.Ingredient;
import com.tavisca.test.model.ingredients.Milk;
import com.tavisca.test.model.ingredients.Sugar;
import com.tavisca.test.model.ingredients.Water;

public class Chai extends Beverage {

	private static final String BVG_NAME = "Chai";
	private final double cost = 4;
	
	@Override
	public double getCost() {
		return cost;
	}

	@Override
	public List<Ingredient> getIngredients() {
		return Stream.of(new Milk(), new Sugar(), new Water()).collect(Collectors.toList());
	}

	@Override
	public String getBeverageName() {
		return BVG_NAME;
	}

}
