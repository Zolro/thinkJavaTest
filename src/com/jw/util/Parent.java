package com.jw.util;

import com.jw.generic.problem.A;

public class Parent implements Eat{
	public void set(A a) {
		// TODO Auto-generated method stub
		System.out.println("Parent.set(a)");
	}
	@Override
	public Parent next() {
		// TODO Auto-generated method stub
		return new Parent();
	}

}
