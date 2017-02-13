package com.jw.generic;

public class GenericMethods {
	public <T> void f(T t){
		System.out.println(t.getClass().getName());
	}
	public static void main(String[] args) {
		GenericMethods methods=new GenericMethods();
		methods.f("");
		methods.f(1);
		methods.f(25l);
		methods.f(false);
		methods.f('c');
		methods.f(methods);
	
	}
}
