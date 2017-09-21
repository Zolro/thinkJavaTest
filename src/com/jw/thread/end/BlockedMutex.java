package com.jw.thread.end;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedMutex implements Runnable {
	private Lock lock=new ReentrantLock();
	public BlockedMutex(){
		lock.lock();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		f();
	}
	public void f(){
		try {
			lock.lockInterruptibly();
			System.out.println("f() lock.lockInterruptibly");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("f() is catch");
		}
	}	
	
}
