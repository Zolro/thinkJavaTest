package com.jw.thread.simulat.hotel;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.jw.enumPackage.Food;

public class Chef implements Runnable {
	private static int counter=0;
	private final int id=counter++;
	private final Restaurant restaurant;
	private static Random rand=new Random(47);
	
	public Chef(Restaurant restaurant) {
		// TODO Auto-generated constructor stub
		this.restaurant=restaurant;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				Order order=restaurant.orders.take();
				Food requestedItem=order.item();
				TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
				Plate plate=new Plate(order, requestedItem);
				order.getWaitPerson().filledOrders.put(plate);
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(this+"interrupted");
		}
		System.out.println(this+"off duty");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Chef "+id+" ";
	}
	public static void main(String[] args) {
		Integer i3=100;
		Integer i4=100;
		System.out.println(i3==i4);
		Integer i5=1000;
		Integer i6=1000;
		System.out.println(i5==i6);
	}
}
