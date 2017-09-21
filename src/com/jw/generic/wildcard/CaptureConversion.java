package com.jw.generic.wildcard;

public class CaptureConversion {
	static <T> void f1(Holder<T> holder){
		
		T t=holder.get();
		System.out.println(t.getClass().getSimpleName());
	}
	static  void f2(Holder<?> holder){
		f1(holder);
	}
	public static void main(String[] args) {
		/*Holder raw=new Holder<Integer>(1);
		f1(raw);
		f2(raw);	
		Holder Basicraw=new Holder();
		Basicraw.set(new Object());
		f2(Basicraw);
		Holder<?> wildcarde=new Holder<Double>(1.0);
		f2(wildcarde);*/
		//-----问题
		
		
	} 
}
