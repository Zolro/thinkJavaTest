package com.jw.generic;

import java.lang.reflect.Array;
import java.util.Arrays;
/**
 * 在泛型类中，类型信息为Object   只有在出边界时 才会转型。
 * @author Administrator
 *
 * @param <T>
 */
public class ArrayMaker<T> {

	private T t;
	private Class<T> kind;
	//public ArrayMaker(Class<T> kind){this.kind=kind;}
	public ArrayMaker(T t){this.t=t;}
	public T get(){return t;};
	public T showT(){
		return t;	
	}
	T[] create(int size){
		return (T[])Array.newInstance(kind,size);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ArrayMaker<String> stringMaker=new 	ArrayMaker<String>(String.class);
		String[] stringArray=stringMaker.create(9);
		
		System.out.println(Arrays.toString(stringArray));*/
		Customer cus=new Customer();
		
		ArrayMaker<Customer> maker=new ArrayMaker<Customer>(cus);
		System.out.println(maker.toString());
		System.out.println(543_213);
	}

}
