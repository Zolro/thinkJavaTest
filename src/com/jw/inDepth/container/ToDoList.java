package com.jw.inDepth.container;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

import com.jw.util.Son;

public class ToDoList extends PriorityQueue<ToDoList.ToDoItem>{
	
	
	static class ToDoItem implements Comparable<ToDoItem> {
		private char primary;
		private int secondary;
		private String item;
		public ToDoItem(String td,char pri,int sec){
			primary=pri;
			secondary=sec;
			item=td;
		}
		@Override
		public int compareTo(ToDoItem arg0) {
			// TODO Auto-generated method stub
			if(primary>arg0.primary)
				return +1;
			if(primary==arg0.primary){
				if(secondary>arg0.secondary)
					return +1;
				else if(secondary==arg0.secondary)
					return 0;
			}
				
			return -1;
		}
		public String toString(){
			return Character.toString(primary)+secondary+":"+item;
		}
	}
	public void add(String td,char pri,int sec){
		super.add(new ToDoItem(td,pri,sec));
	}
	
	public static void main(String[] args) {
		/*ToDoList toDoList=new ToDoList();
		toDoList.add("Empty trash",'C',4);
		toDoList.add("Feed dog",'A',2);
		toDoList.add("Feed bird",'B',7);
		toDoList.add("Mow lawn",'C',3);
		toDoList.add("Water lawn",'A',1);
		//toDoList.add("Feed cat",'B',1);
		while(!toDoList.isEmpty()){
			System.out.println(toDoList.remove());
		}*/
		/*int a=2039;
		System.out.println(Integer.toBinaryString(a));
		int b=a>>5;
		System.out.println(Integer.toBinaryString(b));*/
		/*Son son=new Son();
		System.out.println(son.hashCode());
		Son son2=new Son();
		System.out.println(son2.hashCode());*/
		System.out.println(974844604^1060516465);
	}
}
