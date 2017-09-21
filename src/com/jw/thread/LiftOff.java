package com.jw.thread;

import java.util.concurrent.TimeUnit;

public class LiftOff implements Runnable {
	protected int countDown=0;
	private static int taskCount=0;
	private final int id=taskCount++;
	public LiftOff(){}
	public LiftOff(int countDown){this.countDown=countDown;}
	public synchronized String status(){
		return "#"+id+"("+
				(countDown > 0 ?countDown:"Liftoff!")+").";
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(countDown-- > 0){
			System.out.println(status());						
			Thread.yield();
			//老的调用方法
			//Thread.sleep(100);
			//javase5/6		
			if(id==2){
				try {
					TimeUnit.MILLISECONDS.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			
		}
	}	
}
