package com.jw.thread.join;

public class DualSynch {
	private Object obj=new Object();
	public synchronized void f(){
		for(int i=0;i<5;i++){
			System.out.println("f()");
			Thread.yield();
		}
	}
	public void g(){
		synchronized (obj) {
			for(int i=0;i<5;i++){
				System.out.println("g()");
				Thread.yield();
			}
		}
	}
}
