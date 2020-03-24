package com.tavisca.test.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tavisca.test.model.beverages.Beverage;
import com.tavisca.test.model.ingredients.Ingredient;

public class Order {
	
	Map<Beverage, List<Ingredient>> orderMap = new HashMap<>();

	public Map<Beverage, List<Ingredient>> getOrderMap() {
		return orderMap;
	}
		
}
