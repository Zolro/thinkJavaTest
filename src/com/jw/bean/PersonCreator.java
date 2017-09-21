package com.jw.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class PersonCreator {
	private Random rand=new Random(47);
	public abstract List<Class<? extends Person>> types();
	public Person randomPer(){
		int n=rand.nextInt(types().size());
		try {
			return types().get(n).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
	public Person[] createArray(int size){
		Person[] result=new Person[size];
		for(int i=0;i<size;i++){
			result[i]=randomPer();
		}
		return result;
	}
	public ArrayList<Person> arrayList(int size){
		ArrayList<Person> result =new ArrayList<Person>();
		Collections.addAll(result,createArray(size));
		return result;
	}
}
