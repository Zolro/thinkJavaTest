package com.jw.thread.simulat.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


public class Restaurant implements Runnable{
	private List<WaitPerson> waitPersons=new ArrayList<>();
	private List<Chef> chefs=new ArrayList<>();
	private ExecutorService exec;
	private static Random rand=new Random(47);
	BlockingQueue<Order> orders=new LinkedBlockingQueue<>();
	public Restaurant(ExecutorService e,int nWaitPersons,int nChefs){
		exec=e;
		for(int i=0;i<nWaitPersons;i++){
			WaitPerson waitPerson=new WaitPerson(this);
			waitPersons.add(waitPerson);
			exec.execute(waitPerson);
		}
		for(int i=0;i<nChefs;i++){
			Chef chef=new Chef(this);
			chefs.add(chef);
			exec.execute(chef);
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				WaitPerson wp=waitPersons.get(rand.nextInt(waitPersons.size()));
				Customer c=new Customer(wp);
				exec.execute(c);
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Restaurant interrupted");
		}
		System.out.println("Restaurant closing");
	}
	
}
