package com.jw.test;

import java.io.File;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.jw.bean.Beast;
import com.jw.bean.Person;
import com.jw.thread.LiftOff;
import com.jw.util.Son;

public class TempTest {

	public static String formatString(float data) {
        DecimalFormat df = new DecimalFormat("#,####"); 
        return df.format(data);
    }
	double getCharge(int daysRented){
			double result=0;
			result+=2;
			if(daysRented>2)
				result=(daysRented-2)*1.5;
		
		return result;
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
			exec.execute(new MyThread());
		exec.shutdown();*/
		/* final int SAMPLING_COUNT = 200;  
	        final double PI = 3.1415926535;  
	        final int TOTAL_AMPLITUDE = 300;  
	          
	        int[] busySpan = new int[SAMPLING_COUNT];   
	        int amplitude = TOTAL_AMPLITUDE/2;  
	        double radian = 0.0;  
	        double radianIncrement = 2.0/(double)SAMPLING_COUNT;  
	        for(int i=0;i<SAMPLING_COUNT;i++){  
	            busySpan[i] = (int)(amplitude+Math.sin(PI*radian)*amplitude);  
	            radian += radianIncrement;  
	        }  	          
	        long startTime = 0;  
	        for(int j=0;;j=(j+1) % SAMPLING_COUNT){  
	            startTime = System.currentTimeMillis();  
	            while((System.currentTimeMillis()-startTime)<=busySpan[j])  
	                ;  
	            Thread.sleep(TOTAL_AMPLITUDE-busySpan[j]);  
	        }  */
		/* int busyTime = 10;  
	        int idleTime = busyTime;  
	          
	        while(true){  
	            long startTime = System.currentTimeMillis();  
	            //busy loop:  
	            while((System.currentTimeMillis()-startTime)<=busyTime)  
	                ;  
	            Thread.sleep(idleTime);  
	        }  */
			

	}
	
}
