package com.jw.thread.deadlock;

import java.util.concurrent.TimeUnit;

public class Lock1 implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Lock1 Running");
			while(true){
				synchronized (DeadLock.obj1) {
					System.out.println("Lock1 lock obj1");
					TimeUnit.SECONDS.sleep(3);
					synchronized (DeadLock.obj2) {
						System.out.println("Lock1 lock obj2");
					}
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
