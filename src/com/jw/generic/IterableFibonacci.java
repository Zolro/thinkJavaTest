package com.jw.generic;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Iterator;

public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
	private int n;
	public IterableFibonacci(int count){n=count;}		
	
	
	public 	Iterator<Integer> iterator(){
		return new Iterator<Integer>(){			
			public boolean hasNext(){
				return n>0;
			}
			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				n--;
				return IterableFibonacci.this.next();
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException();
			}
			
		};
	
	}
	public static void main(String[] args) {
		IterableFibonacci iaf=new IterableFibonacci(18);
		for(int i:iaf)
			System.out.println(i+"");
		
	}

	
	
}
