package com.jw.container;

import java.util.Arrays;
public class ArrayList<E>{
	private transient Object[] elementData;
	private static final Object[] EMPTY_ELEMENTDATA = new Object[0];
	protected transient int modCount = 0;
	private int size;
	
	public ArrayList() {
		this.elementData = EMPTY_ELEMENTDATA;
	}
	public int size() {
		return this.size;
	}
	
	
	public boolean add(E paramE) {
		ensureCapacityInternal(this.size + 1);
		System.out.println("size:"+size);
		this.elementData[(this.size++)] = paramE;//把对象放入数组
		for(Object e:this.elementData){
			if(e!=null)
				System.out.println(e.toString());										
		}
		System.out.println("--------------");
		return true;
	}
	private void ensureCapacityInternal(int paramInt) {
		if (this.elementData == EMPTY_ELEMENTDATA)//如果数组为空着赋予paramInt:10
			paramInt = Math.max(10, paramInt);//max():比较2个值大小，返回大的值。
		System.out.println("paramInt:"+paramInt);
		ensureExplicitCapacity(paramInt);
	}
	private void ensureExplicitCapacity(int paramInt) {
		this.modCount += 1;
		System.out.println("modCount:"+modCount);
		if (paramInt - this.elementData.length <= 0)//如果数组大于size return;
			return;
		grow(paramInt);
	}
	private void grow(int paramInt) {
		int i = this.elementData.length;
		System.out.println("i:"+i);
		int j = i + (i >> 1);
		if (j - paramInt < 0)
			j = paramInt;
		if (j - 2147483639 > 0)
			j = hugeCapacity(paramInt);
		System.out.println("j:"+j);
		this.elementData = Arrays.copyOf(this.elementData, j);
		System.out.println("this.elementData.length:"+this.elementData.length);
	}
	private static int hugeCapacity(int paramInt) {
		if (paramInt < 0)
			throw new OutOfMemoryError();
		return ((paramInt > 2147483639) ? 2147483647 : 2147483639);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String txt = "在十九世纪的法国，有一个拉丁语教师，他有一个很普通的法国名字"
				+"老弗回国了，见到了久别的故乡和亲人，也见到了一年不见的刚满三岁小侄子。一年不见，小侄子已经是个可爱的，一直说个不停的小话匣子了。记得去年自己出国走的时候，他还只能咿咿呀呀胡比乱画呢，怎么才一年就成这样儿了。他一定有个学习语言的秘密！老弗开始意识到语言教师可能“都搞错了”，外语也许不该这样学。于是他开始天天泡小孩子了，观察和分析他们掌握语言的奇特本领。倔强有时是有回报的，弗朗索瓦提出了续列法Series"; 


		ArrayList<String>  list=new ArrayList<String>();
		for(String s:txt.split("，|。")){
			System.out.println(s);
			list.add(s);
			/*
			 *1.
			 *	ensureCapacityInternal(1)
			 *	ensureExplicitCapacity(10);  modCount=1
			 *	grow(10);  i=0>>j=0>>j=10				
			 *	elementData[0]=Phaser size=1   elementData[10]
			 *	
			 *	ensureCapacityInternal(2)
			 *	ensureExplicitCapacity(2);  modCount=2
			 *	
			 * 	elementData[1]=or size=2
			 */
		}
		System.out.println(list.size());
	}

}
