package com.jw.thread.help;

import com.jw.enumPackage.Food;
import com.jw.thread.simulat.bank.Customer;

public class WaitPerson implements Runnable {
	private Restaurant rest;
	public WaitPerson(Restaurant rest){ this.rest=rest;}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				synchronized (this) {
					while(rest.meal==null)
						wait();
				}
				System.out.println("Waitperson got "+rest.meal);
				synchronized (rest.chef) {
					rest.meal=null;
					rest.chef.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Waitperson interrupted");
		}
	}
	public void placeOrder(com.jw.thread.simulat.hotel.Customer customer, Food food) {
		// TODO Auto-generated method stub
		
	}

}
