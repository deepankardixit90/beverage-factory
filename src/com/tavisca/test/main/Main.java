package com.tavisca.test.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import com.tavisca.test.model.beverages.Beverage;
import com.tavisca.test.model.beverages.BeverageFactory;
import com.tavisca.test.model.beverages.BeveragesEnum;
import com.tavisca.test.model.ingredients.Ingredient;
import com.tavisca.test.model.ingredients.IngredientFactory;
import com.tavisca.test.model.ingredients.IngredientsEnum;
import com.tavisca.test.order.OrderProcessor;
import com.tavisca.test.order.OrderValidator;

public class Main {

	private static final String ITEM_DELIMITER = ",";

	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("No Order(s) found.......Aborting");
			return;
		}

		Set<IllegalArgumentException> set = new HashSet<>();
		OrderProcessor orderProcessor = new OrderProcessor();
		IngredientFactory ingredientFactory = new IngredientFactory();
		BeverageFactory beverageFactory = new BeverageFactory();

		for (int i = 0; i < args.length; ++i) {
			if (args[i].contains(ITEM_DELIMITER)) {
				String[] arrString = args[i].split(ITEM_DELIMITER);
				Beverage beverage = getBeverage(beverageFactory, arrString[0], set);
				List<Ingredient> list = getIngredients(ingredientFactory, arrString, set);		
				if (null != beverage && OrderValidator.isValidOrder(beverage.getIngredients(), list)) {
					orderProcessor.processOrder(beverage, list);
				} else {				
					set.add(new IllegalArgumentException("Not enough ingredients for the beverage - "+beverage.getBeverageName()));
				}		
			} else {
				Beverage beverage = getBeverage(beverageFactory, args[i], set);
				if (null != beverage) {
					orderProcessor.processOrder(beverage);
				}
			}
		}
		if (set.size() > 0) {
			set.stream().forEach(System.out::println);
		} else {
			double orderPrice = orderProcessor.getOrderPrice();
			System.out.println("Order Price  = $"+orderPrice);
		}
	}

	private static Beverage getBeverage(BeverageFactory beverageFactory, String arrString, Set<IllegalArgumentException> set) {

		Beverage beverage = null;

		if (Stream.of(BeveragesEnum.values()).anyMatch(item -> item.name().equalsIgnoreCase(arrString))) {
			for (BeveragesEnum val : BeveragesEnum.values()) {
				if (val.name().equalsIgnoreCase(arrString)) {
					beverage = beverageFactory.getBeverage(arrString.trim());
				}
			}
		} else {
			set.add(new IllegalArgumentException(" Beverage(s) in Order not found in Menu -- "+ arrString)) ;
		}
		return beverage;
	}

	private static List<Ingredient> getIngredients(IngredientFactory ingredientFactory, String[] arrString, Set<IllegalArgumentException> set) {

		List<Ingredient> list = new ArrayList<>();
		for (int j = 1; j < arrString.length; ++j) {
			String ingredient = arrString[j];
			String actualIngredient = ingredient.trim().substring(1);
			if (Stream.of(IngredientsEnum.values()).anyMatch(item -> item.name().equalsIgnoreCase(actualIngredient))) {
				for (IngredientsEnum val : IngredientsEnum.values()) {
					if (val.name().equalsIgnoreCase(actualIngredient)) {
						list.add(ingredientFactory.getIngredient(val.name().trim()));
					}
				}
			} else {
				set.add(new IllegalArgumentException(" Ingredient(s) in Order not found in Menu -- "+actualIngredient));
			}
		}
		return list;
	}
}
