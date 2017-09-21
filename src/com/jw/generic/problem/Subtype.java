package com.jw.generic.problem;

import com.jw.generic.wildcard.Holder;
import com.jw.util.Son;

public class Subtype extends Holder<Subtype> {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subtype st1=new Subtype();
		Subtype st2=new Subtype();
		st1.set(st2);
		Subtype st3=st1.get();
		st1.f();
		
	}

}
