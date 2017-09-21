package com.jw.generic;

import java.io.ObjectInputStream.GetField;

public class Foo2<T> {
	private T x;
	public <F extends Generator<T>> Foo2(F factory){
		x=factory.next();
	}
}
