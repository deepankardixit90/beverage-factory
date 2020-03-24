package com.tavisca.test.model.beverages;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.tavisca.test.model.ingredients.Ingredient;
import com.tavisca.test.model.ingredients.Mint;
import com.tavisca.test.model.ingredients.Soda;
import com.tavisca.test.model.ingredients.Sugar;
import com.tavisca.test.model.ingredients.Water;

public class Mojito extends Beverage{
	
	private static final String BVG_NAME = "Mojito";
	private final double cost = 7;

	@Override
	public double getCost() {
		return cost;
	}

	@Override
	public List<Ingredient> getIngredients() {
		return Stream.of(new Soda(), new Sugar(), new Water(), new Mint()).collect(Collectors.toList());
	}

	@Override
	public String getBeverageName() {
		return BVG_NAME;
	}

}
