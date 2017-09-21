package com.jw.thread.end;

import java.util.Random;

public class Count {
	private int count=0;
	private Random ran=new Random(47);
	public  int increment(){
		int temp=count;
		if(ran.nextBoolean()){
			Thread.yield();
		}
		return (count=++temp);
	}
	public synchronized int value(){return count;}
}
