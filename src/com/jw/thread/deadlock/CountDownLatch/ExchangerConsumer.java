package com.jw.thread.deadlock.CountDownLatch;

import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerConsumer<T> implements Runnable{
	private Exchanger<List<T>> exchanger;
	private List<T> holder;
	private volatile T value;
	public ExchangerConsumer(Exchanger<List<T>> ex,List<T> holder){
		this.exchanger=ex;
		this.holder=holder;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!Thread.interrupted()){
			try {
				holder=exchanger.exchange(holder);
				for(T x:holder){
					System.out.println(x.toString());
					value=x;
					holder.remove(x);
				}					
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}

}
