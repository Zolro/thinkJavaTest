package com.jw.generic.wildcard;

import java.util.ArrayList;
import java.util.List;

import com.jw.util.Grandson;
import com.jw.util.Parent;
import com.jw.util.Son;
import com.jw.util.Son2;

public class GenericWriting {
	
	static List<Son> sons=new ArrayList<Son>();
	static List<Parent> pars=new ArrayList<Parent>();
	
	static <T> void writeExact(List<T> list,T item){
		list.add(item);
	}
	static void f1(){
		writeExact(sons,new Son());
		writeExact(pars,new Son());
		
	}
	static <T> void writeWithWildcard(List<? super T> list,T item){
		list.add(item);
	}
	static void f2(){
		writeWithWildcard(sons,new Son());
		writeWithWildcard(pars, new Son());
	}
	public static void main(String[] args) {
		//f1();
		//f2();
		writeExact(pars,new Son());
		
	}
}
