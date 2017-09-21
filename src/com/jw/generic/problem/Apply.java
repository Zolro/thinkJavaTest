package com.jw.generic.problem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.jw.util.Son;
/**
 * 潜在类型机制
 * @author Administrator
 *
 */
public class Apply {
	public static <T,S extends Iterable<? extends T>> void apply(S seq,Method f,Object...args){
			for(T t:seq){
				try {
					f.invoke(t,args);
				} catch (IllegalAccessException |IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		//Apply.apply(new FilledList<>(Son.class,10),Son.class.getMethod("rotate")); 
		
		Apply.apply(new FilledList<>(Son.class,10),Son.class.getMethod("resize",int.class),5); 
	}
}
