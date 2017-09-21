package com.jw.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class BasicGenerator<T> implements Generator<T>{
	private Class<T> type;
	
	public BasicGenerator(Class<T> type) {
		// TODO Auto-generated constructor stub
		this.type=type;
	}
	@Override
	public T next() {
		// TODO Auto-generated method stub
		try {
			return type.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static <T> Generator<T> create(Class<T> type){
		return new BasicGenerator<T>(type);
	}
	public static void main(String[] args) {
		Generator<CountedObject> gen=BasicGenerator.create(CountedObject.class);
		for(int i=0;i<5;i++){
			System.out.println(gen.next());
		}
	
	
	}
}
