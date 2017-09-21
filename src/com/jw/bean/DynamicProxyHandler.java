package com.jw.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler{
	private Object proxied;
	
	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}
	@Override
	public Object invoke(Object proxy, Method method,
			Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("******proxy:"+proxy.getClass()+",method:"+method+",arg:"+args);
		if(args!=null)
			for(Object arg:args)
				System.out.println("  "+arg);
		return method.invoke(proxied, args);
	}

}
