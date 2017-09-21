package com.jw.thread.join;


public class Joiner extends Thread {
	private Sleeper sleeper;

	public Joiner(String name,Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}
	@Override
	public void run() {
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Interrupted");
		}
		System.out.println(getName()+" join completed");
	}
	
}
