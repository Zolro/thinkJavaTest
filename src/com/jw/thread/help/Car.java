package com.jw.thread.help;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car {
	//老版本
/*	private boolean waxOn=false;
	public synchronized void waxed(){
		waxOn=true;
		notifyAll();
		//notify();
	}
	public synchronized void buffed(){
		waxOn=false;
		notifyAll();
		//notify();
	}
	public synchronized void waitForWaxing() throws InterruptedException{
		while(waxOn==false){
			wait();
		}
	}
	public synchronized void waitForBuffing() throws InterruptedException{
		while(waxOn==true){
			wait();	
		}
	}	*/
	
	//jdk1.5 
	private Lock lock=new ReentrantLock();
	private Condition condition=lock.newCondition();
	private boolean waxOn=false;
	public synchronized void waxed(){
		lock.lock();
		try{
			waxOn=true;
			condition.signalAll();
		}finally{
			lock.unlock();
		}
		
		
	}
	public synchronized void buffed(){
		lock.lock();
		try{
			waxOn=false;
			condition.signalAll();
		}finally{
			lock.unlock();
		}
		
	}
	public synchronized void waitForWaxing() throws InterruptedException{		
		lock.lock();
		try{
			while(waxOn==false){
				condition.await();
			}			
		}finally{
			lock.unlock();
		}
		
	}
	public synchronized void waitForBuffing() throws InterruptedException{		
		lock.lock();
		try{			
			while(waxOn==true){
				condition.await();
			}
		}finally{
			lock.unlock();
		}
	}	
}
