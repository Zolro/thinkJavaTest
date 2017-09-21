package com.jw.thread.help;

import java.util.concurrent.TimeUnit;

public class WaxOn implements Runnable {
	private Car car;
	public WaxOn(Car c){ car=c;}
	@Override
	public void run() {		
		// TODO Auto-generated method stub	
		try {
			while(!Thread.interrupted()){
				System.out.println("Wax On");
				TimeUnit.MILLISECONDS.sleep(200);
				 car.waxed();//释放挂起线程 waxOff			
				car.waitForBuffing();//挂起本线程
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending Wax On task");
	}	
}
