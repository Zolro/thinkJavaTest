package com.jw.thread.end;

public class BlockedMutex2 implements Runnable {
	private BlockedMutex mutex=new BlockedMutex();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		mutex.f();
	}

}
