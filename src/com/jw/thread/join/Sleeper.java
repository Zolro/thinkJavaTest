package com.jw.thread.join;

public class Sleeper extends Thread {
	private int duration;
	
	public Sleeper(String name,int sleepTime) {
		super(name);
		this.duration = sleepTime;
		start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(getName()+" was interrupted. isInterrupted(): "+interrupted());
			return;
		}
		System.out.println(getName()+" has awakened");
	}

}
