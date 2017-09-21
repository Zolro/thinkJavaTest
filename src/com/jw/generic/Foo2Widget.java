package com.jw.generic;

public class Foo2Widget {
	public static class GeneratorI implements Generator<Foo2Widget>{
		public Foo2Widget next(){
			return new Foo2Widget();
		}
	}
}
