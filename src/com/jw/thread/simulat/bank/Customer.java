package com.jw.thread.simulat.bank;

public class Customer {
	private final int serviceTime;
	public Customer(int tm){
		this.serviceTime=tm;
	}
	
	public int getServiceTime() {
		return serviceTime;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[客户编号："+serviceTime+"]";
	}
}
