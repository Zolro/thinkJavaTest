package thinkJava2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Random;

public class A implements Serializable {
	private int i;
	private transient String s;
	public static int j=0;
	private A a;

	public A() {

	}

	public A(int i, String s, A a) {
		this.i = i;
		this.s = s;
		this.a = a;
	}
	
	@Override
	public String toString() {
		return "A [i=" + i + ", a=" + a + "]";
	}

	/*
	 * public static void main(String[] args) { Random ran=new Random(47);
	 * Random ran1=new Random(47); for(int i=0;i<10;i++){
	 * System.out.println("ran: "+ran.nextInt());
	 * System.out.println("ran1: "+ran1.nextInt()); }
	 * 
	 * }
	 */
	
	public static void main(String[] args) {
		/*System.getProperties().list(System.out);
		System.out.print(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.libray.path"));*/
		A a=new A();
		System.out.println(a.i);
	}

}
