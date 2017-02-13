package com.jw.test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.jw.bean.Beast;
import com.jw.bean.Person;

public class TempTest {
	public static String formatString(float data) {
        DecimalFormat df = new DecimalFormat("#,####"); 
        return df.format(data);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
	}

}
