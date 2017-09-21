package com.jw.generic.potentialType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CommunicateReflectively {
	public static void perform(Object speaker){
		Class<?> spkr=speaker.getClass();
		try {
			Method speak=spkr.getMethod("speak");
			speak.invoke(speaker);
			Method sit=spkr.getMethod("sit");
			sit.invoke(speaker);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
