package com.jw.generic;

import java.util.ArrayList;
import java.util.List;



public class ListMaker<T>{
	private Class t;


	List<T> create(){return new ArrayList<T>();}
	
	public static void main(String[] args) {
		ListMaker<String> stringMaker=new ListMaker<String>();
		List<String> stringList=stringMaker.create();
		System.out.println(stringList.getClass());
	}
}
