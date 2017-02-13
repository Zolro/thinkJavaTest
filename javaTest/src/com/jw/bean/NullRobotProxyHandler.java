package com.jw.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import com.jw.port.Operation;
import com.jw.port.Robot;

public class NullRobotProxyHandler implements InvocationHandler {
	private String nullName;
	private Robot proxied=new NRobot();
	
	
	
	public NullRobotProxyHandler(Class<? extends Robot> type) {
		nullName=type.getSimpleName()+"NullRobot";
	}
	class NRobot implements NULL,Robot{
		
		@Override
		public String name() {
			// TODO Auto-generated method stub
			return nullName;
		}

		@Override
		public String model() {
			// TODO Auto-generated method stub
			return nullName;
		}

		@Override
		public List<Operation> operations() {
			// TODO Auto-generated method stub
			return Collections.emptyList();
		}
		
	}
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		// TODO Auto-generated method stub
		return arg1.invoke(proxied, arg2);
	}
}
