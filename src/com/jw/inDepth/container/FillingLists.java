package com.jw.inDepth.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




import com.jw.util.Son;

public class FillingLists {
	public static void main(String[] args) {
		List<Son> list= new ArrayList<Son>(Collections.nCopies(4,new Son("King")));
		//List<Son> list= new ArrayList<Son>();
		//System.out.println(list);
		Collections.fill(list,new Son("Queen"));
		System.out.println(list);
	}
	
}
