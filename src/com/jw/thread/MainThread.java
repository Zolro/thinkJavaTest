package com.jw.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread {
	public static void main(String[] args) {
		/*LiftOff lunch=new LiftOff(10);
		lunch.run();
		Thread t=new Thread(new LiftOff(10));
		t.start();
		System.out.println("waiting for LiftOff");*/
		/*for(int i=0;i<5;i++)
			new Thread(new LiftOff(10)).start();
		System.out.println("waiting for LiftOff");*/
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
			exec.execute(new LiftOff(10));
		exec.shutdown();
		System.out.println("waiting for LiftOff");
	}
}
