package com.jw.generic.problem;

public class B extends SelfBounded<A>{
	/*B setAndGet(B arg){set(arg); return get();}*/
	public static void main(String[] args) {
		B b=new B();
		A a=b.get();
	}
}
