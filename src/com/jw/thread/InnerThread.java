package com.jw.thread;

public class InnerThread {
	private int countDown=5;
	
	/**
	 * 内部类方法1
	 * @author Administrator
	 *
	 */
	/*
	 * private Inner inner;
	 * private class Inner extends Thread{
		Inner(String name){
			super(name);
			start();
		}
		public void run(){
			try {
				while(true){
					System.out.println(this);
					if(--countDown==0) return;
					sleep(10);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public  String toString(){
			return getName()+": "+countDown;
		}
	}*/
	/**
	 * 内部类方法2
	 * @author Administrator
	 *
	 */
	private Thread t;
	public InnerThread(String name){
		t=new Thread(name){
			public void run(){
				try {
					while(true){
						System.out.println(this);
						if(--countDown==0) return;
						sleep(10);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			public String toString(){
				return getName()+": "+countDown; 
			}
		};
		t.start();
	}
}
