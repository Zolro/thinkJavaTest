package com.jw.test;

import java.util.Arrays;
import java.util.List;

import com.jw.port.Operation;
import com.jw.port.Robot;

public class SnowRemovalRobot implements Robot {
	private String name;
	private String model;
	
	public SnowRemovalRobot(String name) {
		this.name = name;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String model() {
		// TODO Auto-generated method stub
		return "SnowBot Series 11";
	}

	@Override
	public List<Operation> operations() {
		// TODO Auto-generated method stub
		return Arrays.asList(
					new Operation(){
						public String description(){
							return name+" can:chip ice";
						}
						public void command(){
							System.out.println(name+"chip ice");
						}
					},
					new Operation(){
						public String description(){
							return name+"can clean the roof";
						}
						public void command(){
							System.out.println("clean roof");
						}
					}
				);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot.Test.test(new SnowRemovalRobot("Slusher"));
	}

}
