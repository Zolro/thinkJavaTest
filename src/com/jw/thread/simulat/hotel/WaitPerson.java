package com.jw.thread.simulat.hotel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

import com.jw.enumPackage.Food;
public class WaitPerson implements Runnable{
	private static int counter=0;
	private final int id=counter++;
	private final Restaurant restaurant;
	BlockingQueue<Plate> filledOrders=new LinkedBlockingQueue();
	public WaitPerson(Restaurant res){this.restaurant=res;}
	public void placeOrder(Customer cust,Food food){
		try {
			restaurant.orders.put(new Order(cust,this,food));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(this+"palcaOrder interrupted");
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				Plate plate=filledOrders.take();
				System.out.println(this+ "received "+plate+" delivering to");
				plate.getOrder().getCustomer().deliver(plate);
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
		return "WaitPerson "+id+" ";
	}
}
