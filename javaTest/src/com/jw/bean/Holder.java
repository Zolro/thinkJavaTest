package com.jw.bean;

public class Holder<T> {
    private T t;
    public Holder(T t){this.t=t;}
    
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Holder<Person> h=new Holder<Person>(new Person());
		Person p=h.getT();
		System.out.println(p.a);
	}

}
