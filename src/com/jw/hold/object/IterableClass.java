package com.jw.hold.object;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public class IterableClass implements Iterable<String>{
	protected String[] words=("And that is how we know the Earth to be banana-shaped.").split(" ");
	
	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<String>() {
			private int index=0;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index<words.length;
			}

			@Override
			public String next() {
				// TODO Auto-generated method stub
				return words[index++];
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
	public static void main(String[] args) {
		//System.out.println(Collections.fill(new IterableClass()));
		/*for(String s:new IterableClass())
			System.out.println(s);*/
	/*	for(Map.Entry entry:System.getenv().entrySet())
			System.out.println(entry.getKey()+" :"+entry.getValue());*/
		
	}	
	
}
