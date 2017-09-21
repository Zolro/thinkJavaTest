package com.jw.thread;

public class RunnableTest implements Runnable {
	public RunnableTest(){System.out.println("开始消息");}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++){
			System.out.println("lift "+i);
			Thread.yield();
		}
		System.out.println("结束消息");
		return;
			
	}
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			new Thread(new RunnableTest()).start();		
		}	
	}
}
