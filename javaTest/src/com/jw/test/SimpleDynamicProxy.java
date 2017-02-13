package com.jw.test;

import java.lang.reflect.Proxy;

import com.jw.bean.DynamicProxyHandler;
import com.jw.bean.Interface;
import com.jw.bean.RealObject;

public class SimpleDynamicProxy {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bobobo");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RealObject real = new RealObject();
		consumer(real);
		System.out.println("-------------------------------------------------");
		Interface proxy = (Interface) Proxy.newProxyInstance(
				Interface.class.getClassLoader(),
				new Class[] { Interface.class }, new DynamicProxyHandler(real));
		consumer(proxy);
	}

}
