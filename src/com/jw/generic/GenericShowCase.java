package com.jw.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericShowCase {
	public static class GenericClass<T> {
		List<String> getListOfPropertyName() { 
			return new ArrayList<String>(); 
			} 
		} 
	public static void main(String[] args) {
		GenericClass raw = new GenericClass(); 
		List<String> list = raw.getListOfPropertyName(); // Warning: Unchecked assignment from List to List<String> }
		
	}
}
