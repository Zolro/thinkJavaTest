package com.jw.generic;

public class ClassAsFactory<T> {
	T x;

	public ClassAsFactory(Class<T> kind) {
		try {
			x=kind.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ClassAsFactory<Customer> fi=new ClassAsFactory<Customer>(Customer.class);
		//ClassAsFactory<Integer> f=new ClassAsFactory<Integer>(Integer.class);//Integer没有默认函数
		
	}
	
}
