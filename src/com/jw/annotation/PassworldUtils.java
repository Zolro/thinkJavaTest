package com.jw.annotation;

public class PassworldUtils {
	@UseCase(id=47,description="Password must contain at least ont mumeric")
	public boolean vilddataPassword(String password){
		return false;
	}
}
