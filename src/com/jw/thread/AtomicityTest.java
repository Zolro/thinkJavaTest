package com.jw.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
	private  int i=0;//可视化问题
	public synchronized int getValue(){return i;}//处于不稳定状态
	private synchronized void evenIcrement(){i++;i++;}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
			evenIcrement();
	}
	public static void main(String[] args) {
		ExecutorService exec=Executors.newCachedThreadPool();
		AtomicityTest at=new AtomicityTest();
		exec.execute(at);
		while(true){
			int val=at.getValue();
			if(val%2!=0){	
				System.out.println(val);
				System.exit(0);
			}
		}
	}
}
