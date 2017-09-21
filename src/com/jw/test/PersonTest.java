package com.jw.test;




import com.jw.bean.Person;

public class PersonTest {
	private static Person person=new Person();
	public void setUp() throws Exception {
	}


	public void testAdd() {
		//fail("Not yet implemented");
		try {
			System.out.println(Class.forName("Person"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	}

}
