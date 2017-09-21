package com.jw.thread.deadlock.CountDownLatch;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Horse implements Runnable {
	private static int counter=0;
	private final int id=counter++;
	private int strides=0;
	private static Random rand=new Random(47);
	private static CyclicBarrier barrier;
	public Horse(CyclicBarrier b){this.barrier=b;}
	public synchronized int getStrides(){return strides;}
	@Override
	public void run() {
			// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				synchronized (this) {
					strides+=rand.nextInt(3);
				}
				barrier.await();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Horse "+id+" ";
	}
	public String tracks(){
		StringBuilder s=new StringBuilder();
		for(int i=0;i<getStrides();i++)
			s.append("*");
		s.append(id);
		return s.toString();
	}
}
