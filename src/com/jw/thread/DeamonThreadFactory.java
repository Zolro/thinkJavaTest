package com.jw.thread;

import java.util.concurrent.ThreadFactory;

public class DeamonThreadFactory implements ThreadFactory {
	
	@Override
	public Thread newThread(Runnable paramRunnable) {
		// TODO Auto-generated method stub
		Thread t=new Thread(paramRunnable);
		t.setDaemon(true);
		return t;
	}

}
