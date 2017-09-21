package com.jw.generic.wildcard;

import java.util.ArrayList;
import java.util.List;

import com.jw.util.Grandson;
import com.jw.util.Parent;
import com.jw.util.Son;
import com.jw.util.Son2;

public class Holder<T> {
	private T value;
	public Holder(){}
	public Holder(T val){value=val;}
	public void set(T val){value=val;}
	public T get(){return value;}
	public boolean equals(Object obj){
		return value.equals(obj);
	}
	public void f(){
		System.out.println(value.getClass().getSimpleName());
	}
	public static void main(String[] args) {
		List<Son> listSon=new ArrayList<Son>();
		
		List<? extends Parent> parList=listSon;
	/*	Holder<Son> Son=new Holder<Son>(new Son());
		Son son=Son.get();	-
		Son.set(son);
		
		Holder<? extends Parent> parent=Son;
		
		Parent p=parent.get();
		son=(Son)parent.get();
		
		
		List<Son> listSon=new ArrayList<Son>();
		listSon.add(new Son());
		List<? extends Parent> parList=listSon;
		
		Parent p2=parList.get(0);
		Son son2 =(Son)parList.get(0);*/
		/*List<? super Son> flist=new ArrayList<Parent>();
		flist.add(new Grandson());*/
		
		Parent son=new Son();
		son=new Son2();
		
		//Son2 s2=(Son2)parent.get();
		
		//System.out.println(parent.equals(son));
	}
}
