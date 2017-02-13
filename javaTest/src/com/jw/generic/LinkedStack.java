package com.jw.generic;

public class LinkedStack<T>{	
	private static class Node<U>{
		U item;
		Node<U> next;
		Node(){
			item=null;
			next=null;
		}
		Node(U item,Node<U> next){
			this.item=item;
			this.next=next;
		}
		boolean end(){
			return item==null&&next==null;
		}
	}	
	private Node<T> top=new Node<T>();	
	public void push(T item){
		top=new Node<T>(item,top);		
	}	
	public T pop(){
		T result=top.item;
		if(!top.end()){
			top=top.next;
		}
		return result;
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *生成泛型类LinkedStack<String> lss  T为String
		 *	调用push(String)方法:为 lsdd  调用带参数的构造方法 产生Node<Strin>(String,Node)内部类     
		 *										生成三个内部类  Node1(Phaser,Node<String> top)
		 *													 Node2(or,Node<String> top)
		 *													  Node3(stun!,Node<String> top)
		 *														并传值内部类中的字段  String item与 Node next 
		 *	调用lss的pop()  赋予 String result=top.item  如果参数字段都不为空 top=top.next 
		 *
		 *		
		 */
		
		LinkedStack<String> lss=new LinkedStack<String>();//Node<String> topNull item=null next=null		
		for(String s:"Phaser or stun!".split(" ")){
			lss.push(s);
			/*
			 * 1.Node<String> top1 item=Phaser next=topNull;
			 * 1.Node<String> top2 item=or next=top1;
			 * 1.Node<String> top3 item=stun! next=top2;
			 * */
		}
		String s;
		while((s=lss.pop())!=null){
			System.out.println(s);
		}
		
		
		
	}

}
