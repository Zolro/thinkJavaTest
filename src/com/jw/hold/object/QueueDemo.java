package com.jw.hold.object;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {
	public static void printQ(Queue queue){
		while(queue.peek()!=null){
			System.out.println(queue.remove()+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		/*Queue<Integer> queue=new LinkedList<>();
		Random ran=new Random(47);
		for(int i=0;i<10;i++){
			queue.offer(ran.nextInt(i+10));
		}
		printQ(queue);*/
		Queue<Character> qc=new LinkedList<>();
		for(char c:"Brontosaurus".toCharArray())
			qc.offer(c);
		
		printQ(qc);
	}
}