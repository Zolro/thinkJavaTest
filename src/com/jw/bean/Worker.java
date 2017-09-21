package com.jw.bean;

public class Worker extends Person {
	private String workType;
	public Worker() {	
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Loding Worker");
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	
}
