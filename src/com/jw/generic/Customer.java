package com.jw.generic;

public class Customer {
	private static long counter;
	private final long id=counter++;
	public Customer(){};
	public long id(){ return id;}
	public String toString(){
		return "Customer "+id;
	}
	public static Generator<Customer> generator(){
		return new Generator<Customer>(){
			public Customer next(){return new Customer();};
		};
	}
	public static void main(String[] args) {
		
	}
}
