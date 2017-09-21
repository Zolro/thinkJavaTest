	package com.jw.thread.join;

public class SyncObject {
	public static void main(String[] args) {
		final DualSynch dualSynch=new DualSynch();
		for(int i=0;i<10;i++){
			new Thread(){
				public void run(){
					dualSynch.f();
				}
			}.start();
			dualSynch.g();
		}
		
	}
}
