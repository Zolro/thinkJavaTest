package com.jw.enumPackage;

import java.util.Random;

public enum Course {
	APPETIZER(Food.Appetizer.class),
	MAINCOURSE(Food.MainCourse.class),
	DESSERT(Food.Dessert.class),
	COFFEE(Food.Coffee.class);
	private Food[] values;
	private Course(Class<? extends Food> kind){
		values=kind.getEnumConstants();
	}
	public Food randomSelection() {
		// TODO Auto-generated method stub	
		return Enums.random(values);
	}	
}	
