package com.jw.inDepth.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class FailFast {
	public static void main(String[] args) {
		Collection<String> c=new ArrayList<String>();
		Iterator<String> it=c.iterator();
		c.add("add Object");		
		String s=it.next();
		
	}
}
