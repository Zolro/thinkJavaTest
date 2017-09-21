package com.jw.thread.end;

import java.util.concurrent.TimeUnit;

public class SleepBlocked implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			TimeUnit.MILLISECONDS.sleep(10);			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("InterruptedException");
		}
		System.out.println("Exiting SleepBlocked.run()");
	}

}
