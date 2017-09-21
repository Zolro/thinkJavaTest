package com.jw.thread;

import java.util.concurrent.ThreadFactory;
/**
 * 设置线程工厂
 * @author Administrator
 *
 */
public class MyThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable arg0) {
		// TODO Auto-generated method stub
		Thread t=new Thread(arg0);
		t.setDaemon(false);
		return t;
	}

}
