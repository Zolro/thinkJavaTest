package com.jw.thread.simulat.bank;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CustomerGenerator implements Runnable{
	private CustomerLine customers;
	private static Random rand=new Random(47);
	public CustomerGenerator(CustomerLine cq){
		this.customers=cq;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
				customers.put(new Customer(rand.nextInt(1000)));
				System.out.println(customers.size()+"位客户在等候");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
