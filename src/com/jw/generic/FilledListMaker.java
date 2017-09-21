package com.jw.generic;

import java.util.ArrayList;
import java.util.List;

public class FilledListMaker<T> {
	List<T> create(T t,int n){
		List<T> result=new ArrayList<T>();
		for(int i=0;i<n;i++){
			result.add(t);
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FilledListMaker<Integer> stringMaker=new FilledListMaker<Integer>();
		List<Integer> list=stringMaker.create(111,4);
		for(int str:list)
			System.out.println(str);
	}

}
