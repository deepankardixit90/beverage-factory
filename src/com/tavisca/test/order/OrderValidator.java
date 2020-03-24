package com.tavisca.test.order;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.tavisca.test.model.ingredients.Ingredient;

public class OrderValidator {
	
	public static boolean isValidOrder(List<Ingredient> ingredients, List<Ingredient> list) {
		Set<?> set = ingredients.stream().map(i -> i.getClass()).collect(Collectors.toSet());
		Set<?> set1 = list.stream().map(i -> i.getClass()).collect(Collectors.toSet());
		return !(set.equals(set1));
	}

}
