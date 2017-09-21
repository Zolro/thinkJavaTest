package com.jw.thread.simulat.hotel;

import com.jw.enumPackage.Food;

public class Order {
	private static int counter=0;
	private final int id=counter++;
	private final Customer customer;
	private final WaitPerson waitPerson;
	private final Food food;
	public Order(Customer coustomer,WaitPerson waitPerson,Food food){
		this.customer=coustomer;
		this.waitPerson=waitPerson;
		this.food=food;
	}
	public Food item(){return food;}
	public Customer getCustomer(){return customer;}
	public WaitPerson getWaitPerson(){return waitPerson;}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Order："+id+"item"+food+"for:"+customer+"served by"+waitPerson;
	}
}
