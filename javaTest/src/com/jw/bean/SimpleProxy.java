package com.jw.bean;

public class SimpleProxy implements Interface{
	private Interface proxied;
	
	
	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("SimpleProxy doSomething");
		proxied.doSomething();
	}

	@Override
	public void somethingElse(String arg) {
		// TODO Auto-generated method stub
		System.out.println("SimpleProxy somethingElse"+arg);
		proxied.somethingElse(arg);
		
	}

}
