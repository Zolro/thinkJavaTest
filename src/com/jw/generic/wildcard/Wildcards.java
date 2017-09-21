package com.jw.generic.wildcard;

import com.jw.util.Grandson;
import com.jw.util.Parent;
import com.jw.util.Son;
import com.jw.util.Son2;

public class Wildcards {
	static void rawArgs(Holder holder,Object arg){
		holder.set(arg); //warning
		holder.set(new Wildcards()); //same warning
		// T t=holder.get();
		Object obj=holder.get();
	}
	static void unboundArgs(Holder<?> holder,Object arg){
		//holder.set(arg);	 error
		//holder.set(new Wildcards()); same error
		Object obj=holder.get();
		
	}
	
	static <T> T exact1(Holder<T> holder){		
		T t=holder.get();
		return t;
	}
	static <T> T exact2(Holder<T> holder,T arg){
		holder.set(arg);
		T t=holder.get();
		return t;
	}
	
	
	static <T> T wildSubtype(Holder<? extends T> holder,T arg){
		//holder.set(arg); error
		T t=holder.get();
		return t;
	}
	static <T> void wildSupertype(Holder<? super T> holder,T arg){
		holder.set(arg); 
		//T t=holder.get();
		Object obj=holder.get();
	}
	public static void main(String[] args) {
		Holder<Son> h=new Holder<Son>();
		Son s=exact2(h,new Grandson());
		rawArgs(new Holder(),new Object());
		
	}
}
