package com.jw.generic;

public class FactoryConstraint {
	public static void main(String[] args) {
		new Foo2<Integer>(new Foo2IntegerFactory());
		new Foo2<Foo2Widget>(new Foo2Widget.GeneratorI());
	}
}
