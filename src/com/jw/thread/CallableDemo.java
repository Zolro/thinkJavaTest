package com.jw.thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<String> {
	private int id;
	public CallableDemo(int id){ this.id=id;};
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		
		return "result of CallableDemo "+id;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec=Executors.newCachedThreadPool();
		/*ArrayList<Future<String>> results=new ArrayList<>();		
		for(int i=0;i<10;i++)
			results.add(exec.submit(new CallableDemo(i)));
		
		for(Future f:results)
			System.out.println(f.get());*/
	
		Future<String> fg=exec.submit(new CallableDemo(5));
		System.out.println(fg.get());		
	}

}
