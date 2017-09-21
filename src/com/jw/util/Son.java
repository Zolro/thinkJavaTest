package com.jw.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.jw.generic.problem.A;
import com.jw.generic.problem.B;

public class Son extends Parent implements Eat {
	private String name;
	
	public String getName() {
		return name;
	}
	
	public Son() {
		super();
	}

	public Son(String name) {
		super();
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void set(B b) {
		// TODO Auto-generated method stub
		System.out.println("Son.set(b)");
	}
	public void rotate(){
		System.out.println(this+"rotate");
	}
	public void resize(int newSize){
		System.out.println(this+" resize "+newSize);
	}
	public static <T extends Eat> T sonTest(Class<T> type) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Constructor<T> ghog=type.getConstructor(String.class);
		
		T cla=ghog.newInstance("Kim");
		
		return cla;
	}
	
	


	public static void main(String[] args) {
		Son son=new Son();
		System.out.println(son.getName());
		/*System.out.println(son.hashCode());
		Map<Integer,Son> map=new HashMap<>();
		map.put(1, son);
				
		System.out.println(map.get(1).hashCode());
		
		son.setName("Qun");
		map.put(1, son);*/
		
	}
}
