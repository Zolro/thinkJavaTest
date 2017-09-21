package com.jw.generic;

public class Holder<T>{
	private T a;
	public Holder(){		
	}	
	public void set(T a){
		this.a=a;
	}
	public T get(){
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Holder<Integer> h=new Holder<Integer>();
		System.out.println(h.get().getClass().getSimpleName());
	}

}
