package com.jw.inDepth.container;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
	public static void main(String[] args) {
		LinkedHashMap<Integer,String> linkedMap=new LinkedHashMap<>();
		for(int i=0;i<10;i++)
			linkedMap.put(i,"A"+i);
		
		System.out.println(linkedMap);
		linkedMap=new LinkedHashMap<>(16,0.75f,true);
		
		for(int i=0;i<10;i++)
			linkedMap.put(i,"b"+i);
		System.out.println(linkedMap);
		for(int i=0;i<6;i++){
			linkedMap.get(i);
		}
		System.out.println(linkedMap);
		linkedMap.get(0);
		System.out.println(linkedMap);
	}
}
