package com.jw.thread.deadlock;

import java.util.concurrent.TimeUnit;

public class Lock2 implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Lock2 Running");
			while(true){				
				synchronized (DeadLock.obj2) {
					System.out.println("Lock2 lock obj2");
					TimeUnit.SECONDS.sleep(3);
					synchronized (DeadLock.obj1) {
						System.out.println("Lock2 lock obj1");
					}
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
