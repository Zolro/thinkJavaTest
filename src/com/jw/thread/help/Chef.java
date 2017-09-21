package com.jw.thread.help;

import java.util.concurrent.TimeUnit;

public class Chef implements Runnable {
	private Restaurant rest;
	private int count=0;
	public Chef(Restaurant rest){ this.rest=rest;}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){				
				synchronized (this) {
					while(rest.meal!=null)
						wait();
				}
				if(++count==10){
					System.out.println("Out of food,closing");
					rest.exec.shutdownNow();
				}
				System.out.print("Order up! ");
				synchronized (rest.waitPerson) {
					rest.meal=new Meal(count);
					rest.waitPerson.notifyAll();
				}
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Chef interrupted");
		}
	}

}
