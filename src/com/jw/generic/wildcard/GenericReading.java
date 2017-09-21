package com.jw.generic.wildcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jw.util.Parent;
import com.jw.util.Son;

public class GenericReading {
	
	static List<Son> sons=Arrays.asList(new Son());
	static List<Parent> pars=Arrays.asList(new Parent());	
	
	
	static <T> T readExact(List<T> list){
		return list.get(0);
	}
	static void f1(){
		Son s=readExact(sons);
		Parent p=readExact(pars);
		p=readExact(sons);
	}
	
	static class Reader<T>{		
		T readExact(List<T> list){
			return list.get(0);
			}
	}
	static void f2(){
		Reader<Parent> parReader=new Reader<Parent>();
		Parent p=parReader.readExact(pars);
		
		/*Parent s=parReader.readExact(sons);
		Reader<Parent> ->  Son readeExcat<Son>(List<Son>){ return sons.get(0); }    List<Son> != List<Parent>
		
		*/
		
		
	}
	
	static class CovariantReader<T>{
		T readCovariant(List<? extends T> list){
			return list.get(0);
		}
	}
	static void f3(){
		CovariantReader<Parent> parReader=new CovariantReader<Parent>();
		Parent p1=parReader.readCovariant(pars);
		Parent p2=parReader.readCovariant(sons);
	}
	public static void main(String[] args) {
		//f1();
		//f2();
		//f3();
		List<? super Son> sons=new ArrayList<>();
		
	}
}
