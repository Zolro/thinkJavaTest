package com.jw.inDepth.container;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Countries {
	public static final String[][] DATA={{"ALGERIA","Algiers"},{"ANGOLA","Luanda"}};
	

	
	private static class FlyweightMap extends AbstractMap<String,String>{
		
		private static class Entry implements Map.Entry<String, String>{
			int index;
			Entry(int index){this.index=index;}
			public boolean equals(Object o){
				return DATA[index][0].equals(o);
			}
			public String getKey(){return DATA[index][0];}
			public String getValue(){return DATA[index][1];}
			public String setValue(String value){
				throw new UnsupportedOperationException();
			}
			public int hashCode(){
				return DATA[index][0].hashCode();
			}
		}
		
		static class EntrySet extends AbstractSet<Map.Entry<String,String>>{
			private int size;
			EntrySet(int size){
				if(size<0)
					this.size=0;
				else if(size>DATA.length)
					this.size=DATA.length;
				else
					this.size=size;
			}
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return size;
			}
			private class Iter implements Iterator<Map.Entry<String, String>>{
				private Entry entry=new Entry(-1);
				
				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return entry.index<size-1;
				}

				@Override
				public java.util.Map.Entry<String, String> next() {
					// TODO Auto-generated method stub
					entry.index++;
					return entry;
				}

				@Override
				public void remove() {
					// TODO Auto-generated method stub
					throw new UnsupportedOperationException();
				}
				
			}
			@Override
			public Iterator<java.util.Map.Entry<String, String>> iterator() {
				// TODO Auto-generated method stub
				return new Iter();
			}
		}
		
		
		private static Set<Map.Entry<String, String>> entries=new EntrySet(DATA.length);
		@Override
		public Set<Map.Entry<String, String>> entrySet() {
			// TODO Auto-generated method stub
			return entries;
		}
		
	}
	
	
	
	static Map<String,String> select(final int size){
		return new FlyweightMap(){
			public Set<Map.Entry<String, String>> entrySet(){
				return new EntrySet(size);
			}
		};
	}
	
	static Map<String,String> map=new FlyweightMap();
	
	public static Map<String,String> capitals(){
		return map;
	}
	
	public static Map<String,String> capitals(int size){
		return select(size);
	}
	
	
	
	static List<String> names=new ArrayList<String>(map.keySet());
	public static List<String> names(){return names;}
	public static List<String> names(int size){
		return new ArrayList<String>(select(size).keySet());
	}
	
	public static void main(String[] args) {
		Countries.FlyweightMap.Entry entry=new Countries.FlyweightMap.Entry(1);
		System.out.println(entry.getKey()+" "+entry.getValue());
	}
}
