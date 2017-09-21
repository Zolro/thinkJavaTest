package com.jw.thread.simulat.hotel;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RestaurantWithQueues {
	public static void main(String[] args) throws NumberFormatException, InterruptedException, IOException {
		ExecutorService exec=Executors.newCachedThreadPool();
		Restaurant restaurant=new Restaurant(exec, 5, 2);
		exec.execute(restaurant);
		if(args.length>0){
			TimeUnit.SECONDS.sleep(new Integer(args[0]));
		}else{
			System.out.println("Press 'Enter' to quit ");
			System.in.read();
		}
		exec.shutdownNow();
	}
}
