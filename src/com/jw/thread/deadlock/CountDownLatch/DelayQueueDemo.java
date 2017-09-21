package com.jw.thread.deadlock.CountDownLatch;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DelayQueueDemo {
	public static void main(String[] args) {
		Random rand=new Random(47);
		ExecutorService exec=Executors.newCachedThreadPool();
		DelayQueue<DelayedTask> queue=new DelayQueue<>();
		for(int i=0;i<20;i++)//生成20个随机延迟的 对象 并添加入  DelayQueue集合容器
			queue.put(new DelayedTask(rand.nextInt(5000)));
		queue.add(new DelayedTask.EndSentinel(5000, exec));//静态内部类  根据 compareTo排序结果  遍历 List 
		exec.execute(new DelayedTaskConsumer(queue));
	}
}
