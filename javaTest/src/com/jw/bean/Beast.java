package com.jw.bean;

import java.io.Serializable;

public class Beast implements Serializable{
	private String name;
	private String sex;
	private int age;
	private Beast() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static Beast single(){
		return new Beast();
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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
