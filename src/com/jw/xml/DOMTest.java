package com.jw.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {
/*	public static void mainTest(String[] args) {
		// 创建一个DocumentBuilderFactory的对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		List<Adress> list = new ArrayList<>();
		// 创建一个DocumentBuilder的对象
		try {
			// 创建DocumentBuilder对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 通过DocumentBuilder对象的parser方法加载books.xml文件到当前项目下
			Document document = db.parse("d://ggll.kml");
			// 获取所有book节点的集合
			NodeList placeList = document.getElementsByTagName("Placemark");
			// 通过nodelist的getLength()方法可以获取bookList的长度
			System.out.println("一共有" + placeList.getLength() + "个地址");
			// 遍历每一个book节点
			for (int i = 0; i < placeList.getLength(); i++) {
				Adress a = new Adress();
				Node place = placeList.item(i);
				NodeList childNodes = place.getChildNodes();
				for(int j=0;j<childNodes.getLength();j++){
					if("name".equals(childNodes.item(j).getNodeName())){
						Node name = childNodes.item(j);
						a.setName(name.getFirstChild().getNodeValue());
						System.out.println(name.getFirstChild().getNodeValue());
					}
					if("LookAt".equals(childNodes.item(j).getNodeName())){
						NodeList lookAtList = childNodes.item(j).getChildNodes();						
						Node lng = lookAtList.item(1);
						Node lat = lookAtList.item(3);
						System.out.println(lng.getFirstChild().getNodeValue()+"|"+lat.getFirstChild().getNodeValue());					
						a.setLat(lat.getFirstChild().getNodeValue());
						a.setLng(lng.getFirstChild().getNodeValue());
					}
						
				}			
				list.add(a);
				System.out.println("======================结束遍历第" + (i + 1)
						+ "个地址的内容=================");
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringBuilder str=new StringBuilder();
		for (Adress a : list){
			System.out.println(a.toString());
			str.append(a.toString());
		}
		testExample(str.toString());
		
	}*/
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, DOMException, ParserConfigurationException, SAXException, IOException {
		List<Placemark> list=getObject("d://tyhfg.kml",Placemark.class);
		StringBuilder str=new StringBuilder();
		for (Placemark a : list){
			System.out.println(a.toString());
			str.append(a.toString());
		}
		testExample(str.toString());
	}	
	public static <T> List<T> getObject(String filePath,Class<T> cla)
			throws ParserConfigurationException, IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, DOMException, SAXException {
		List<T> list = new ArrayList<T>();//容器填充遍历出的对象 要求：类名、属性名 同 节点一致		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(filePath);//把问卷转换为Document对象

		NodeList placeList = document.getElementsByTagName(cla.getSimpleName());

		Field[] fileds = cla.getDeclaredFields(); 
		for (int i = 0; i < placeList.getLength(); i++) {
			T t =  cla.newInstance();		
			Node place = placeList.item(i);
			NodeList placeNodes = place.getChildNodes();					
			for(int j=0;j<placeNodes.getLength();j++){
				//System.out.println(placeNodes.item(j).getNodeName()+"的长度:"+placeNodes.item(j).getChildNodes().getLength());
				for(Field filed:fileds){
					if(placeNodes.item(j).getChildNodes().getLength()>1){
						NodeList placeSonNodes = placeNodes.item(j).getChildNodes();
						for(int b=0;b<placeSonNodes.getLength();b++){
							if(filed.getName().equals(placeSonNodes.item(b).getNodeName())){
								Node name = placeSonNodes.item(b);
								String method="set"+(filed.getName().substring(0, 1).toUpperCase()+filed.getName().substring(1));					
								Method m = cla.getMethod(method,String.class);
								m.invoke(t,name.getFirstChild().getNodeValue());  												
							}
						}
					}else{
						if(filed.getName().equals(placeNodes.item(j).getNodeName())){
							Node name = placeNodes.item(j);
							String method="set"+(filed.getName().substring(0, 1).toUpperCase()+filed.getName().substring(1));					
							Method m = cla.getMethod(method,String.class);
							m.invoke(t,name.getFirstChild().getNodeValue());  												
						}
					}
					
				}
				/*if("name".equals(childNodes.item(j).getNodeName())){
					Node name = childNodes.item(j);
					a.setName(name.getFirstChild().getNodeValue());
					System.out.println(name.getFirstChild().getNodeValue());
				}*/
				/*if("LookAt".equals(childNodes.item(j).getNodeName())){
					NodeList lookAtList = childNodes.item(j).getChildNodes();						
					Node lng = lookAtList.item(1);
					Node lat = lookAtList.item(3);				
					a.setLat(lat.getFirstChild().getNodeValue());
					a.setLng(lng.getFirstChild().getNodeValue());
				}*/
					
			}			
			list.add(t);
			System.out.println("======================结束遍历第" + (i + 1)
					+ "个地址的内容=================");
		}		
		return list;
	}
	 public String creaTObject(Field filed,Node node){
		 String value=null;
		if(node.getChildNodes().getLength()>1){
			NodeList nodes = node.getChildNodes();
			for(int i=0;i<nodes.getLength();i++){
				creaTObject(filed,nodes.item(i));
			}			
		}else{
			if(filed.getName().equals(node.getNodeName()))
				value=node.getFirstChild().getNodeValue();
		}
		return value;
		 
	 }
	 
	 
	 static void testExample(String txt){	       
	        try {
	            //1、打开流
	            Writer w=new FileWriter("g:/Jinweidu.txt",true);
	            //2、写入内容
	            w.write(txt);
	            //3、关闭流
	            w.close();
	        } catch (IOException e) {
	            System.out.println("文件写入错误："+e.getMessage());
	        }
	    }
}
