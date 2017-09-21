package com.jw.thread.help;

import java.util.concurrent.TimeUnit;

public class WaxOff implements Runnable {
	private Car car;
	public WaxOff(Car c){car=c;}
	@Override
	public void run() {		
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				car.waitForWaxing();//本线程挂起  开始waxOn
				System.out.println("Wax Off");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();//释放挂起的waxOn线程
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending Wax Off task");
	}
}
