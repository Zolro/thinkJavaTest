package com.jw.bean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class LiteralPersonCreator extends PersonCreator {
	public static final List<Class<? extends Person>> allTypes = Collections
			.unmodifiableList(Arrays.asList(
					Person.class, Studet.class,
					Worker.class	));
	private static final List<Class<? extends Person>> types = allTypes
			.subList(allTypes.indexOf(Studet.class), allTypes.size());

	@Override
	public List<Class<? extends Person>> types() {
		// TODO Auto-generated method stub
		return types;
	}
	
}
