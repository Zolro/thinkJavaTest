package com.jw.bean;

import java.util.HashMap;
import java.util.Map;

public class Person {
	private String name;
	private String sex;
	private int age;
	public static int a=17;
	//public static final int NUM=47;
	
	/*public static final Map<String,String> map=new HashMap<String,String>(){
			{
				put("1号","草泥马");
				put("2号","雅蠛蝶");
			}
		};
	static { 
		System.out.println("Loding Person");
		}*/
	public Person() {
		super();
		System.out.println("Super Person");
	}
	public Person(String name, String sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void add(int n){
		age=age+n;
		System.out.println(age);
	}
	public static class NULLPerson extends Person implements NULL{
		private NULLPerson(){super("none","none",0);};
		public String toString() {return "NULLPerson";}
		
	}
	public static final Person NULL=new NULLPerson();

	
	
}
