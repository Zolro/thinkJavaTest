package com.jw.bean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Man{

	public Man() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void test(Object object){
		Method[] methods=object.getClass().getMethods();
		Constructor[] ctors=object.getClass().getConstructors();
		Field[] f=object.getClass().getFields();
		for(Method m:methods)
			System.out.println(m.toString());
		System.out.println("---------------------------------------------------------------------------"); 		
 			System.out.println(ctors[0].getName()); 
 			System.out.println(ctors.length);
 			System.out.println("---------------------------------------------------------------------------"); 	
 			for(Field fi:f)
 				System.out.println(fi.toString());
	}
}
