package com.jw.bean;

import java.util.ArrayList;
import java.util.List;

public class ForNamCreator extends PersonCreator {
	private static List<Class<? extends Person>> types=new ArrayList<Class<? extends Person>>();
	private static String[] typeNames={
		"com.jw.bean.Worker",
		"com.jw.bean.Studet"
	};
	@SuppressWarnings("unchecked")
	private static void loader(){
		for(String str:typeNames){
			try {
				types.add((Class<? extends Person>)Class.forName(str));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
	static{loader();}
	@Override
	public List<Class<? extends Person>> types() {
		// TODO Auto-generated method stub
		return types;
	}

}
