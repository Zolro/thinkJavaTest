package com.jw.thread.deadlock.CountDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Pool<T> {
	private int size;
	private List<T> items = new ArrayList<>();
	private volatile boolean[] checkedOut;
	private Semaphore available;// 信号量控制

	public Pool(Class<T> classObj, int size) {// 构造Pool
		this.size = size;
		checkedOut = new boolean[size];// 设置布尔数组 初始值false
		available = new Semaphore(size, true);// 初始 计数信号量
		for (int i = 0; i < size; i++) {// 向List 表中 填充对象
			try {
				items.add(classObj.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public T checkOut() throws InterruptedException {
		available.acquire();// 获取许可
		return getItem();//赋予布尔数组SIZE个 ture值  	
	}

	public void checkIn(T x) {
		if (releaseItem(x))//如果x对象对应
			available.release();// 释放许可
	}

	private synchronized T getItem() {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; ++i) {
			if (!checkedOut[i]) {
				checkedOut[i] = true;
				return items.get(i);
			}
		}
		return null;
	}

	private synchronized boolean releaseItem(T item) {
		// TODO Auto-generated method stub
		int index = items.indexOf(item);
		if (index == -1)
			return false;
		if (checkedOut[index]) {
			checkedOut[index] = false;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// 线程池
		ExecutorService exec = Executors.newCachedThreadPool();
		// 只能5个线程同时访问
		final Semaphore semp = new Semaphore(5);
		// 模拟20个客户端访问
		for (int index = 0; index < 20; index++) {
			final int NO = index;
			Runnable run = new Runnable() {
				public void run() {
					try {
						//获取许可
						semp.acquire();
						System.out.println("Accessing: " + NO);
						Thread.sleep((long) (Math.random() * 10000));
						//访问完后，释放
						semp.release();
						System.out.println("-----------------"
								+ semp.availablePermits());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			exec.execute(run);
		}
		// 退出线程池
		exec.shutdown();
	}
}
