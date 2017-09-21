package com.jw.thread.simulat.bank;

import java.util.concurrent.TimeUnit;

public class Teller implements Runnable,Comparable<Teller>{
	private static int counter=0;
	private final int id=counter++;
	
	private int customersService=0;
	private CustomerLine customers;//队列
	private boolean servingCustomerLine=true;
	public Teller(CustomerLine cq){
		this.customers=cq;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {		
			while(!Thread.interrupted()){
				Customer customer=customers.take();//取出队列头部元素
				TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());//休眠
				synchronized (this) {//锁码
					customersService++;//参数+1
					while(!servingCustomerLine){//如果是fasle 挂起
					System.out.println(this+"空闲");
						wait();
					}
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(this+" interrupted");
		}
		System.out.println(this+" terminating");
	}
	public synchronized void doSomethingElse(){
		customersService=0;
		servingCustomerLine=false;
	}
	public synchronized void serveCustomerLine(){
		assert !servingCustomerLine:"already serving :"+this;
		servingCustomerLine=true;
		System.out.println(this+"开始服务");
		notifyAll();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "客服编号 "+id+" ";
	}
	public String shortString (){return "客服编号："+id;}
	@Override
	public synchronized int compareTo(Teller o) {//比较customersService的大小
		// TODO Auto-generated method stub
		return customersService<o.customersService?-1:
			(customersService==o.customersService?0:1);
	}

	
	
	
	
}
