package com.jw.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import javax.management.RuntimeErrorException;

public class AttemptLocking {
	private ReentrantLock lock=new ReentrantLock();
	public void untimed(){
		boolean captured=lock.tryLock();
		try{
			System.out.println("tryLock(): "+captured);
		}finally{
			if(captured){
				lock.unlock();
			}
		}
	}
	public void timed(){
		boolean captured=false;
		 try {
			captured=lock.tryLock(2,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		 try {
				System.out.println("tryLock(2,TimeUnit.SECONDS): "+captured);
			}finally{
				if(captured){
					lock.unlock();
				}
			}
		
	}
	public static void main(String[] args) {
		final AttemptLocking al=new AttemptLocking();
		al.untimed();
		al.timed();
		new Thread(){
			{setDaemon(true);}
			public void run(){
				/*try {
					Thread.currentThread().sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("sleep error");
					e.printStackTrace();
				}*/
				al.lock.lock();
				System.out.println("acquired");
			}
		}.start();
	}
}
