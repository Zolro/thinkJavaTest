package com.jw.array;

import java.util.Random;


import com.jw.generic.Generator;

public  class CompType implements Comparable<CompType>{
	int i;
	int j;
	private static int count=1;
	public CompType(int n1,int n2){
		i=n1;
		j=n2;
	}
	public String toString(){
		String result="[ i="+i+",j="+j+"]";
		if(count++%3==0){
			result+="\n";
		}
		return result;
	}
	@Override
	public int compareTo(CompType paramT) {
		// TODO Auto-generated method stub
		return (i<paramT.i?-1:(i==paramT.i?0:1));
	}
	private static Random ran=new Random(47);
	public static Generator<CompType> generator(){
		return new Generator<CompType>(){
			@Override
			public CompType next() {
				// TODO Auto-generated method stub
				return new CompType(ran.nextInt(100), ran.nextInt(100));
			}
			
		};
		
	}
}