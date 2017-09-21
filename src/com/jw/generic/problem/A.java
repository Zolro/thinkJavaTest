package com.jw.generic.problem;

public class A extends SelfBounded<A>{
	
	public static void main(String[] args) {
		A a=f(new A());
	}
}
