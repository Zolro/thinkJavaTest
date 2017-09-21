package com.jw.thread.help;

public class Task2 implements Runnable {
	static Blocker blocker=new Blocker();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		blocker.waitingCall();
	}
	
}
