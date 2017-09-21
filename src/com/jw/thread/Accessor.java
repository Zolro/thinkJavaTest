package com.jw.thread;

public class Accessor implements Runnable {
	private final int id;
	public Accessor(int idn){
		id=idn;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!Thread.currentThread().isInterrupted()){
			ThreadLocalVariableHolder.increment();	
			System.out.println(this);
			Thread.yield();
		}
	}
	
	@Override
	public String toString(){		
		return "#"+id+": "+
				ThreadLocalVariableHolder.get();
	}
}
