package com.jw.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread implements Runnable{
	private AtomicInteger ticket=new AtomicInteger(20);
	//private Lock lock=new ReentrantLock();
	@Override
	public  void run() {
		// TODO Auto-generated method stub	
		for(int i=0;i<20;i++){
			if(this.ticket.get()>0)
				System.out.println(Thread.currentThread()+" ticket: "+this.ticket.getAndDecrement());
		}
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
