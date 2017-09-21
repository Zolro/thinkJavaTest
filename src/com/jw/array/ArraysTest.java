package com.jw.array;

import java.util.Arrays;
import java.util.Random;

import com.jw.generic.Generator;

public class ArraysTest {
	static void copyingArrays(){
		int[] i=new int[7];
		int[] j=new int[10];
		Arrays.fill(i,47);
		Arrays.fill(j,99);
		System.out.println("i= "+Arrays.toString(i));
		System.out.println("j= "+Arrays.toString(j));
		System.arraycopy(i, 0, j, 1, i.length-1);
		System.out.println("j= "+Arrays.toString(j));
	}

	public static void main(String[] args) {
		//ArraysTest.copyingArrays();
		
	}
}
