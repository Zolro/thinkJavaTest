package com.jw.thread.help;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {
	Meal meal;
	ExecutorService exec= Executors.newCachedThreadPool();
	Chef chef=new Chef(this);
	WaitPerson waitPerson=new WaitPerson(this);
	
	public Restaurant(){
		exec.execute(chef);
		exec.execute(waitPerson);
	}
	
	public static void main(String[] args) {
		new Restaurant();
	}
}
