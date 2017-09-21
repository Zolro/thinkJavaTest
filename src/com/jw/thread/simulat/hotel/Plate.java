package com.jw.thread.simulat.hotel;

import com.jw.enumPackage.Food;

public class Plate {
	private final Order order;
	private final Food food;
	public Plate(Order order,Food food){
		this.order=order;
		this.food=food;
	}
	public Order getOrder() {
		return order;
	}
	public Food getFood() {
		return food;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return food.toString();
	}
}
