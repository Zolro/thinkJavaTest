package com.jw.thread.deadlock.CountDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



public class HorseRec {
	static final int FINISH_LINE=75;
	private List<Horse> horses=new ArrayList<>();
	private ExecutorService exec=Executors.newCachedThreadPool();
	private CyclicBarrier barrier;
	public HorseRec(int nHorses,final int pause){
		barrier=new CyclicBarrier(nHorses ,new Runnable(){			
			@Override
			public void run() {
				// TODO Auto-generated method stubd
				StringBuilder s=new StringBuilder();
				for(int i=0;i<FINISH_LINE;i++)
					s.append("=");	
				System.out.println(s);
				for(Horse horse:horses)
					if(horse.getStrides()>=FINISH_LINE){
						System.out.println(horse+" won!");
						exec.shutdownNow();
						return;
					}
				
				try {
					TimeUnit.MILLISECONDS.sleep(pause);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		});
		for(int i=0;i<nHorses;i++){
			Horse horse=new Horse(barrier);
			horses.add(horse);
			exec.execute(horse);
		}
	}
	public static void main(String[] args) {
		int nHorses=7;
		int pause=200;
		/*if(args.length>0){
			int n=new Integer(args[0]);
			nHorses=n>0?n:nHorses;
		}
		if(args.length>1){
			int p=new Integer(args[1]);
			nHorses=p>-1?p:pause;
		}*/
		new HorseRec(nHorses, pause);
	}
}
