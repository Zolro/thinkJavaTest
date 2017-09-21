package com.jw.thread.simulat.bank;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import javax.management.Query;
import javax.print.attribute.standard.PrintQuality;

public class TellerManager implements Runnable{
	private ExecutorService exec;
	private CustomerLine customers;
	private PriorityQueue<Teller> workingTellers=new PriorityQueue<Teller>();
	private Queue<Teller> tellersDoingOtherThings=new LinkedList<Teller>();
	private int adjustmentPeriod;
	private static Random rand=new Random(47);
	public TellerManager(ExecutorService e,CustomerLine customers,int adjustmentPeriod){	
		this.exec=e;//线程池
		this.customers=customers;//客户队列
		this.adjustmentPeriod=adjustmentPeriod;
		Teller teller=new Teller(customers);//线程类Teller
		exec.execute(teller);//取出队列头部元素并从中删除、休眠、根据内部参数某条件 挂起或释放
		workingTellers.add(teller);//teller添加到 队列中
	}
	public void ajustTellerNumber(){
		if(customers.size()/workingTellers.size()>2){//如果客户人数是客服的2倍
			if(tellersDoingOtherThings.size()>0){//如果有闲置的客服
				Teller teller=tellersDoingOtherThings.remove();//从闲置的客服队获取客服对象
				teller.serveCustomerLine();//改变状态
				workingTellers.offer(teller);//插入到服务客服队列中
				return;
			}
		
			Teller teller=new Teller(customers);
			System.out.println(teller+"添加");
			exec.execute(teller);
			workingTellers.add(teller);
			return;
		}
		if(workingTellers.size()>1&&customers.size()/workingTellers.size()<2)
				reassignOneTeller();
		if(customers.size()==0){
			while(workingTellers.size()>1){
				reassignOneTeller();
			}		
		}
	
	}
	private void reassignOneTeller() {
		// TODO Auto-generated method stub
		Teller teller=workingTellers.poll();
		teller.doSomethingElse();
		tellersDoingOtherThings.offer(teller);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				System.out.println(this+"休眠"+adjustmentPeriod+"秒，进入阻塞状态");
				TimeUnit.SECONDS.sleep(adjustmentPeriod);
				ajustTellerNumber();
				System.out.println(customers+" { ");
				for(Teller teller:workingTellers)
					System.out.println(teller.shortString()+" 正在服务");
				System.out.println(" } ");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "TellerManager";
	}

}
