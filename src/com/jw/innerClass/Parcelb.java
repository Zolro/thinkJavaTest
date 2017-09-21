package com.jw.innerClass;

public class Parcelb {
	/*public Contents contents(int x){
		return new Contents(x){			
			public int value(){return super.value()*47;}
		};
	
	}*/
	//在内部类中引用外部定义的参数  参数必须 final
	public Contents contents(final String x){
		return new Contents(){
			private String label=x;
			private int i;
			{	
				i=58;				
			}
			
			public String valueStr(){return label;}
			public int value(){return i;}
		};
	
	}
	
	public static void main(String[] args) {
		Parcelb p=new Parcelb();
		Contents c=p.contents("color is blue");
		System.out.println(c.valueStr());
		System.out.println(c.value());
		
	}
}
