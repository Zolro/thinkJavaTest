package com.jw.bean;

import java.util.HashMap;

public class PersonCount {
	static class PerCounter extends HashMap<String,Integer>{
		public void count(String type){
			Integer quantity=get(type);
			if(quantity==null)
				put(type, 1);
			else
				put(type,quantity+1);
		}
	}
	public static void coutPers(PersonCreator creator){
		PerCounter counter=new PerCounter();
		for(Person per:creator.createArray(2)){
			System.out.println(per.getClass().getSimpleName());
			if(per instanceof Person)
				counter.count("Person");
			if(per instanceof Worker)
				counter.count("Worker");
			if(per instanceof Studet)
				counter.count("Studet");
			System.out.println(counter);
		}
	
	}
	public static void main(String[] args) {
		coutPers(new LiteralPersonCreator());
	}
}
