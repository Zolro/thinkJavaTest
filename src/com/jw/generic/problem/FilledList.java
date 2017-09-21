package com.jw.generic.problem;

import java.util.ArrayList;

public class FilledList<T> extends ArrayList<T>{
	public FilledList(Class<? extends T> type,int size){
		for(int i=0;i<size;i++){
			try {
				add(type.newInstance());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
