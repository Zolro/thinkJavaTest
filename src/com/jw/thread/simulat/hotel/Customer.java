package com.jw.thread.simulat.hotel;

import java.util.concurrent.SynchronousQueue;

import com.jw.enumPackage.Course;
import com.jw.enumPackage.Food;

public class Customer implements Runnable{
	private static int counter=0;
	private final int id=counter++;
	private final WaitPerson waitPerson;
	private SynchronousQueue<Plate> palceSetting=new SynchronousQueue<>();
	public  Customer(WaitPerson waitPerson) {
		// TODO Auto-generated constructor stub
		this.waitPerson=waitPerson;	
	}
	public void deliver(Plate p) throws InterruptedException{
		palceSetting.put(p);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(Course course:Course.values()){
			Food food=course.randomSelection();
			try {
				waitPerson.placeOrder(this,food);
				System.out.println(this+"eating "+palceSetting.take());
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(this+"waiting for "+course+"interrupted");
				break;
			}
		}
		System.out.println(this+"finished meal ,leaving");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer"+id+" ";
	}
	
	
}
