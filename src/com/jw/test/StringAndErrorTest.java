package com.jw.test;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAndErrorTest {
	private static Logger logger = Logger.getLogger("Test");

	/*
	 * static void logException(Exception e) { StringWriter trace = new
	 * StringWriter(); e.printStackTrace(new PrintWriter(trace));
	 * logger.severe(trace.toString()); }
	 */
	private static void test1() throws Exception {
		try {
			test2();
		} catch (NullPointerException ex) {
			// throw (Exception)ex.fillInStackTrace();
			// throw new Exception();
			// throw new Exception("packag exception", ex);
			ex.printStackTrace();		
			System.err.println("-------------------------");
			throw new RuntimeException(ex);
		}

	}

	private static void test2() {
		test3();
	}

	private static void test3() {
		throw new NullPointerException("str is null");
	}
	public  void test4(){
		System.out.println(this);
	}
	public static void main(String[] args) throws Exception {
		 //test1();
		String str="Evening is Even full Even of the even linnet's wings  \n";
		Pattern p=Pattern.compile("\\w");//.compile("(\\w+ing)\\w?");//编译后的正则表达式
		/*String[] w=p.split(str,3);
		for(String s:w){
			System.out.println(s);
		}*/
		Matcher m=p.matcher(str);//匹配输入的字符串  返回 Matcher对象  该对象包含了 匹配的结果等信息
		
		StringBuffer sub=new StringBuffer();
		//System.out.println(m.groupCount());
		while(m.find()){
			/*System.out.println(m.start());
			System.out.println(m.end());
			System.out.println(m.group(0)+" ");
			System.out.println("--------------------------");*/
			m.appendReplacement(sub,"@");
			m.appendTail(sub);
			System.out.println(sub);
			
		}
		
		 
		StringAndErrorTest test=new StringAndErrorTest();
		test.test4();
		//while(m.find())
			
		    
		
		/*
		int i=0;
		while(m.find(i)){
			System.out.println(m.group()+":"+i);
			i++;
		}*/
	
		//String[] strs=p.split(str);

		// TODO Auto-generated method stub
		/*
		 * try { throw new NullPointerException(); } catch (NullPointerException
		 * e) { // TODO Auto-generated catch block logException(e); }
		 * System.out.
		 * println("--------------------------------------------------------------"
		 * ); try { throw new NullPointerException(); } catch (Exception e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
		
	}

}
