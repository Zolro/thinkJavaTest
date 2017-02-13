package com.jw.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.jw.bean.Man;
import com.jw.bean.Person;
import com.jw.bean.Worker;

public class ReflectTest {


	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		Person p1=new Person();
		//Worker w1=new Worker();
		//String s=new String();
		/*Class p=Person.class;
		Class w=Worker.class;
		
		System.out.println(p.equals(p1.getClass()));*/
		/*Method[] methods=p.getMethods();
		Constructor[] ctor=p.getConstructors();
		for(Method m:methods)
			System.out.println(m.getName());
		System.out.println("---------------------------------------------------------------------------");
 		for(Constructor c:ctor)
 			System.out.println(c.getName());*/
		//Man.test(p1);
		//Man.test(w1);	
		p1.setAge(15);
		p1.setName("KK");
		p1.setSex("man");
		Field[] fields=Person.class.getDeclaredFields();
		 for(int i=0;i<fields.length;i++)
		  {
		   System.out.println(fields[i].toString());
		   
		  }
		//System.out.println(w1.getClass());
		 /*Class<Worker> c= Worker.class;
			System.out.println(c.getSimpleName());
			Worker w= c.newInstance();
			Class<? super Worker> up=c.getSuperclass();
			Object p=up.newInstance();*/
			
			//Class c=Person.class;
			//Person p=new Person();
			/*Worker w=new Worker();
			Person p=new Person();
			Random rand=new Random(47);
			System.out.println(rand.nextInt(9));*/
		 	/*List<Class<? extends Person>> list=Arrays.asList(Person.class,Studet.class,Worker.class);
		 
		 	 Map<String,Class<? extends Person>> map=new HashMap<String,Class<? extends Person>>(){
		 		{
		 			put("1",Person.class);
		 			put("2",Studet.class);
		 			put("3",Worker.class);
		 		}
		 	};
		 	
		 	for(Entry<String, Class<? extends Person>> c:map.entrySet()){
		 		
		 			
		 	}*/
		    System.out.println(Person.a);
			
			//Class<Worker> wo=Worker.class;
			
			
			/*Worker wor=wo.cast(w);
			wor=(Worker)w;*/                             
		
	}
	

}
