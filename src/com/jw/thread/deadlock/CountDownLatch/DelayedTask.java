package com.jw.thread.deadlock.CountDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;



public class DelayedTask implements Runnable,Delayed{
	private static int counter=0;
	private final int id=counter++;
	private final int delta;
	private final long trigger;
	protected static List<DelayedTask> sequence=new ArrayList<DelayedTask>();
	public DelayedTask(int delayInMilliseconds){
		delta=delayInMilliseconds;//ID
		trigger=System.nanoTime()+TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MILLISECONDS);//延迟时间
		sequence.add(this);//把生成的对象 加入Listzhong 
	}
	@Override
	public int compareTo(Delayed arg0) {  //根据延迟  比较大小
		// TODO Auto-generated method stub
		DelayedTask that=(DelayedTask)arg0;
		if(trigger<that.trigger) return -1;
		if(trigger>that.trigger) return 1;
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		return unit.convert(trigger-System.nanoTime(),TimeUnit.NANOSECONDS);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this+" ");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%1$-4d]",delta)+"Task "+id;
	}
	public String summary(){
		return "("+id+":"+delta+")";
	}
	
	public static class EndSentinel extends DelayedTask{
		private ExecutorService exec;
		public EndSentinel(int delay,ExecutorService e) {
			super(delay);
			exec=e;
			// TODO Auto-generated constructor stub
		}
		public void run(){
			for(DelayedTask pt:sequence)
				System.out.println(pt.summary());
			System.out.println();
			System.out.println(this +"Calling shutdownNow()");
			exec.shutdownNow();
		}
	}	
}
