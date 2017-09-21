package com.jw.thread.simulat.bank;

import java.util.concurrent.ArrayBlockingQueue;

public class CustomerLine extends ArrayBlockingQueue<Customer> {

	public CustomerLine(int maxLineSize) {
		super(maxLineSize);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (this.size() == 0)
			return "[Empty]";
		StringBuilder result = new StringBuilder();
		for (Customer customer : this) {
			result.append(customer);
		}
		return result.toString();
	}

}
