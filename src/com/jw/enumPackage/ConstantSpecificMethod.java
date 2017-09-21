package com.jw.enumPackage;

import java.text.DateFormat;
import java.util.Date;

public enum ConstantSpecificMethod {
	DATE_TIME{
		String getInfo(){
			return DateFormat.getDateInstance().format(new Date());
		}
	},
	CLASSPATH{
		String getInfo(){
			return System.getenv("CLASSPATH");
		}
	},
	VERSION{
		String getInfo(){
			return System.getProperty("java.version");
		}
	};
	abstract String getInfo();//表驱动的代码（table-driven code）
	public static void main(String[] args) {
		for(ConstantSpecificMethod c:values())
			System.out.println(c.getInfo());
	}
}
