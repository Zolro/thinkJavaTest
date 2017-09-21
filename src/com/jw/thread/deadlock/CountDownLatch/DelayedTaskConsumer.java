package com.jw.thread.deadlock.CountDownLatch;

import java.util.concurrent.DelayQueue;

public class DelayedTaskConsumer implements Runnable{
	private DelayQueue<DelayedTask> q;
	public DelayedTaskConsumer(DelayQueue<DelayedTask> q){
		this.q=q;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted())
				q.take();//根据排序输出[获取并删除表头对象]
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finished DelayedTaskConsumer");
	}
}
