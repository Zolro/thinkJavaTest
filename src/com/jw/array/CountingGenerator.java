package com.jw.array;

import com.jw.generic.Generator;

public class CountingGenerator {
	public static class Boolean implements Generator<java.lang.Boolean>{
		private boolean value=false;
		@Override
		public java.lang.Boolean next() {
			// TODO Auto-generated method stub
			value=!value;
			return value;
		}
		
	}
}
