package com.jw.thread;

import java.util.concurrent.TimeUnit;

public class ADaemon implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Starting ADaemon");
		try {
			TimeUnit.SECONDS.sleep(10);			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Exiting via InterruptedException");
		}finally{
			System.out.println("This should always run?");
		}
	}
	
	public static void main(String[] args) {
		Thread t=new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
	}
}
