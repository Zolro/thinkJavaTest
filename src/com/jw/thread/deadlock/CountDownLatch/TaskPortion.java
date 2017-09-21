package com.jw.thread.deadlock.CountDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TaskPortion implements Runnable {
	private static int count=0;
	private static final int id=count++;
	private static Random rand=new Random(47);
	private final CountDownLatch latch;
	public TaskPortion(CountDownLatch latch){
		this.latch=latch;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		doWork();
		latch.countDown();
	}
	public void doWork() {
		// TODO Auto-generated method stub
		try {
			TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this +"completed");
	}
	@Override 
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%1$-3d",id);
	}
}
