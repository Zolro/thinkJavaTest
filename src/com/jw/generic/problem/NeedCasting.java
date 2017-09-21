package com.jw.generic.problem;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import com.jw.util.Son;
public class NeedCasting<T,W>{
	void f(List<T> v){}
	//void f(List<W> v){}
	public void f(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream in=new ObjectInputStream(new FileInputStream(args[0]));	
		
		List<Son> sons=(List<Son>) in.readObject();
		
		List<Son> sons2=List.class.cast(in.readObject());
	}
}
