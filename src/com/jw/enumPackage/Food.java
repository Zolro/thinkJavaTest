package com.jw.enumPackage;

public interface Food {
	enum Appetizer implements Food{
		SALAD,SOUP,SPRING_ROLLS;
	}
	enum MainCourse implements Food{
		LASAGNE,BURRITO,PAD_THAI,
		LENTILS,HUMMOUS,VINDALOO;
	}
	enum Dessert implements Food{
		TIRAMISU,GELATO,BLACK_FOREST_CAKE,
		FRUIT,CREME_CAREMEL;
	}
	enum Coffee implements Food{
		BLACK_COFFEE,DECAF,FRUIT;
	}
	
}
