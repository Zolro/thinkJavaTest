package com.jw.generic.border;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;






import com.jw.util.Parent;
import com.jw.util.Son;
import com.jw.util.Son2;

public class CovariantArrays {
	public static void main(String[] args) {
		/*List<? extends Parent> flist=Arrays.asList(new Son());
		Son s=(Son)flist.get(0);
		flist.contains(new Son());
		flist.indexOf(new Son());*/
		
		/*Parent[] a=new Parent[5];
		a[0]=new Son();*/
		
		/*Parent[] p=new Son[10];
		p[0]=new Son();
		p[1]=new Son2();
		p[3]=new Parent();*/
		/*List<Son> sons=new ArrayList<>();
		List<? extends Parent> pars=sons;
		pars.add(new Parent());*/
		
	}
}
