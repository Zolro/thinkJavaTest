package com.jw.util;

public abstract class IntegerNum {
	private boolean flag=false;
	
	public abstract int next();
	public boolean isFlag(){return flag;}
	public void changeFlag(){flag=true;};
}
