package com.jw.thread.deadlock.CountDownLatch;

import java.util.List;
import java.util.concurrent.Exchanger;

import com.jw.generic.Generator;

public class ExchangerProducer<T> implements Runnable{
	private Generator<T> generator;
	private Exchanger<List<T>> exchanger;
	private List<T> holder;
	ExchangerProducer(Exchanger<List<T>> exchg,List<T> holder,Generator<T> generator){
		this.exchanger=exchg;
		this.holder=holder;
		this.generator=generator;
		}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!Thread.interrupted()){
			try {
				for(int i=0;i<ExchangerDemo.size;i++)
					holder.add(generator.next());
				holder=exchanger.exchange(holder);				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
