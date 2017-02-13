package com.jw.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 元祖
 * @author Administrator
 *
 * @param <A>
 * @param <B>
 */
public class TwoTuple<A,B>{
	public final A first;
	public final B second;
	public TwoTuple(A a,B b){first=a; second=b;}
	@Override
	public String toString() {
		return "TwoTuple [first=" + first + ", second=" + second + "]";
	}
	public static void main(String[] args) {
		List<TwoTuple<String,String>> tupleList=new ArrayList<TwoTuple<String,String>>();
		
	}
}
