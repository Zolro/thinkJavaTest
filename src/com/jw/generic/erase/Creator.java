package com.jw.generic.erase;

public class Creator extends GenericWithCreate<X>{
	@Override
	X create() {
		// TODO Auto-generated method stub
		return new X();
	}
	void f(){
		System.out.println(element.getClass().getSimpleName());
	}
	public static void main(String[] args) {
		Creator c=new Creator();
		c.f();
	}
}
