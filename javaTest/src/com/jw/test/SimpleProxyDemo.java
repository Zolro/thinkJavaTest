package com.jw.test;

import java.lang.reflect.Proxy;

import com.jw.bean.DynamicProxyHandler;
import com.jw.bean.Interface;
import com.jw.bean.RealObject;
import com.jw.bean.SimpleProxy;

public class SimpleProxyDemo {
	public static void consumer(Interface iface){
		iface.doSomething();
		iface.somethingElse("bobobo");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 简单代理
		 */
		//consumer(new RealObject());
		//consumer(new SimpleProxy(new RealObject()));
		//动态代理  SimpleDynameicProxy
		RealObject real = new RealObject();
		Interface proxy = (Interface) Proxy.newProxyInstance(
				Interface.class.getClassLoader(),
				new Class[] { Interface.class}, new DynamicProxyHandler(real));
		consumer(proxy);
	}

}
