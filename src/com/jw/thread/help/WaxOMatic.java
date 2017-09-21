package com.jw.thread.help;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxOMatic {
	public static void main(String[] args) throws InterruptedException {
		/**
		 * 同一个对象，不同线程对不同方法调用的切换
		 */
		Car car=new Car();
		ExecutorService exec=Executors.newCachedThreadPool();
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}
}
