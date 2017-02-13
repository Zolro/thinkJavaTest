package com.jw.generic;

public class BasicGenerator<T> implements Generator<T>{
	private Class<T> type;
	
	public BasicGenerator(Class<T> type) {
		// TODO Auto-generated constructor stub
		this.type=type;
	}
	@Override
	public T next() {
		// TODO Auto-generated method stub
		try {
			return type.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static <T> Generator<T> create(Class<T> type){
		return new BasicGenerator<T>(type);
	}
	public static void main(String[] args) {
		System.out.println(BasicGenerator.create(String.class));
		System.out.println(new BasicGenerator(String.class));
	}
}
