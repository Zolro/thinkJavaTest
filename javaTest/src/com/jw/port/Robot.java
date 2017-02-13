package com.jw.port;

import java.util.List;

import com.jw.bean.NULL;

public interface Robot {
	String name();
	String model();
	List<Operation> operations();
	class Test{
		public static void test(Robot r){
			if(r instanceof NULL)
				System.out.println("[Null Robot]");
			System.out.println("Robot name:"+r.name());
			System.out.println("Robot model:"+r.model());
			for(Operation opertion:r.operations()){
				System.out.println(opertion.description());
				opertion.command();
			}
		}
	}
}
