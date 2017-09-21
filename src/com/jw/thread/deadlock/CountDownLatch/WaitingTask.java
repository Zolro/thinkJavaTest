package com.jw.thread.deadlock.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class WaitingTask implements Runnable{
	private static int count=0;
	private static final int id=count++;
	private final CountDownLatch latch;
	WaitingTask(CountDownLatch latch){
		this.latch=latch;
	}
	@Override
	public void run() {	
		// TODO Auto-generated method stub
		try {			
			latch.await();
			System.out.println("Latch barrier passed for"+this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(this+"interrupted");
		}	
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("WaitingTask %1$-3d",id);
	}
}
