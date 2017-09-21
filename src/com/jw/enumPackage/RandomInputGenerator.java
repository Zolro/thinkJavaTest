package com.jw.enumPackage;

public class RandomInputGenerator implements Generator<Input> {
	
	
	@Override
	public Input next() {
		// TODO Auto-generated method stub
		return Input.randomSelection();
	}

}
