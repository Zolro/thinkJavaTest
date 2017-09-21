package com.jw.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true){
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread()+": "+this);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("sleep() interrupted");
		}
	}
	public static void main(String[] args) throws InterruptedException {
	/*	for(int i=0;i<10;i++){
			Thread daemon=new Thread(new SimpleDaemons());
			daemon.setDaemon(true);
			daemon.start();
		}
		System.out.println("All daemon started");
		TimeUnit.MILLISECONDS.sleep(175);*/
		for(int i=0;i<10;i++){
		ExecutorService exec=Executors.newCachedThreadPool(new MyThreadFactory());
		exec.execute(new SimpleDaemons());
		exec.shutdown();
		}
		System.out.println("All daemon started");
		TimeUnit.MILLISECONDS.sleep(20);
		
	}
	
}
