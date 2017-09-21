package com.jw.generic.erase;

public abstract class GenericWithCreate<T> {
	final T element;
	GenericWithCreate(){element=create();}
	abstract T create();
}
