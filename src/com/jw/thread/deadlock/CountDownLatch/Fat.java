package com.jw.thread.deadlock.CountDownLatch;

public class Fat {
	private volatile double d;
	private static int counter=0;
	private final static int id=counter++;
	public Fat(){
		for(int i=0;i<10000;i++){
			d+=(Math.PI+Math.E)/(double)i;
			System.out.println(i);
		}
			
	}
	public void operation(){
		System.out.println(this);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Fat id: "+id;
	}
	/*public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		Fat fat=new Fat();
		System.out.println(System.currentTimeMillis());
	}*/
}
