package com.jw.thread.deadlock.CountDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class PrioritizedTask implements Runnable,Comparable<PrioritizedTask>{
	private Random rand=new Random(47);
	private static int counter=0;
	private final int id=counter++;
	private final int priority;
	protected static List<PrioritizedTask> 	sequence=new ArrayList<>(); 
	public PrioritizedTask(int priority){
		this.priority=priority;
		sequence.add(this);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%1$-3d]", priority)+"Task"+id;
	}
	public String summary(){
		return "("+id+":"+priority+")";
	}
	@Override
	public int compareTo(PrioritizedTask paramT) {
		// TODO Auto-generated method stub		
		return priority< paramT.priority?1:(priority>paramT.priority?-1:0);
	}

}
