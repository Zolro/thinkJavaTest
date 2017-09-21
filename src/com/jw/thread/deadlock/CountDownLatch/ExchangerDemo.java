package com.jw.thread.deadlock.CountDownLatch;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.basic.BasicArrowButton;

import com.jw.generic.BasicGenerator;

public class ExchangerDemo {
	static int size=10;
	static int delay=5;
	public static void main(String[] args) throws InterruptedException {//公用Exchanger对象
		ExecutorService exec=Executors.newCachedThreadPool();
		Exchanger<List<Fat>> xc=new Exchanger<>(); 
		List<Fat> producerList=new CopyOnWriteArrayList<>();
		List<Fat> consumerList=new CopyOnWriteArrayList<>();
		exec.execute(new ExchangerProducer<Fat>(xc,producerList, BasicGenerator.create(Fat.class)));
		exec.execute(new ExchangerConsumer<>(xc, consumerList));
		TimeUnit.SECONDS.sleep(delay);
		exec.shutdownNow();
	}
}
