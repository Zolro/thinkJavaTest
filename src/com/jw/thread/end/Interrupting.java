package com.jw.thread.end;

import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Interrupting {
	private static ExecutorService exec=Executors.newCachedThreadPool();
	static void test(Runnable r) throws InterruptedException{
		Future<?> f=exec.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("Interrupting "+r.getClass().getName());
		f.cancel(true);
		System.out.println("Interrupt sent to "+r.getClass().getName());	
	}
	static void testNoEnd(Runnable r){
		exec.execute(r);
		exec.shutdown();
	}
	public static void main(String[] args) throws InterruptedException {
		//test(new SleepBlocked());
		//testNoEnd(new SleepBlocked());
		//testNoEnd(new IOBlocked(System.in));
		//test(new IOBlocked(System.in));	
		//test(new SynchronizedBlocked());
		//test(new BlockedMutex2());
		Thread t=new Thread(new BlockedMutex());
		t.start();
		t.interrupt();
		TimeUnit.MILLISECONDS.sleep(3);
		System.out.println("Aborting with System.exit(0)");
		System.exit(0);
	}
}
