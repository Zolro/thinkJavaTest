package com.jw.test;

import java.lang.reflect.Proxy;

import com.jw.bean.NULL;
import com.jw.bean.NullRobotProxyHandler;
import com.jw.port.Robot;

public class NullRobot {
	
	public static Robot newNullRobot(Class<? extends Robot> type){
		return (Robot)Proxy.newProxyInstance(NullRobot.class.getClassLoader(), 
				new Class[]{NULL.class,Robot.class},new NullRobotProxyHandler(type));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot[] bots={
				new SnowRemovalRobot("SnowBee"),
				newNullRobot(SnowRemovalRobot.class)	
		};
		for(Robot bot:bots){
			Robot.Test.test(bot);
		}
	}

}
