package com.jw.enumPackage;

import java.io.*;
import java.util.Iterator;

public class FileInputGenerator implements Generator<Input> {
	private Iterator<String> input;
	public FileInputGenerator(String fileName){
		//input=new TextFile(fileName,";").iterator();
	}
	@Override
	public Input next() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		
	}
}
