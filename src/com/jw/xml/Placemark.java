package com.jw.xml;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Placemark {
	private String name;
	private String longitude;
	private String latitude;
	private String coordinates;
	
	public String getCoordinates() {
		return coordinates;
	}



	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}



	public String getName() {
		System.out.println("get"+name);
		return name;
	}

	
	
	public void setName(String name) {
		this.name = name;
	}



	public String getLongitude() {
		return longitude;
	}



	public String getLatitude() {
		return latitude;
	}



	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}



	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}



	public void foo(String name){
		System.out.println(name);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ 地址：" + name + ",经度：" + latitude + ",纬度：" + longitude + ",经纬网："+coordinates+"]";
	}

	public static void main(String[] args) throws  ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//Adress addr=new Adress();
		
		/*Field[] fileds = t.getDeclaredFields(); 
		Method[] methods = t.getMethods();   
		for(Field filed:fileds){
		
			
		}*/
		/*String methodName="setName";
		Method method =t.getMethod(methodName,t);
		method.invoke(addr,"123");
		System.out.println(addr.getName());*/	
		Class clz =Placemark.class;
		Object o = clz.newInstance();
		Method m = clz.getMethod("setName", String.class);
		m.invoke(o,"北京");
		
		Method m1 = clz.getMethod("getName");
		m1.invoke(o);
		
		
	
		
	}
}
