package com.jw.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jw.bean.Person;

public class PersonTest {
	private static Person person=new Person();
	@Before
	public void setUp() throws Exception {
	}

	@Test
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
