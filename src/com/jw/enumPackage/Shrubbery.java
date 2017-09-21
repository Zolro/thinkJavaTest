package com.jw.enumPackage;

import java.util.EnumSet;

public enum Shrubbery {
	GROUND("the ground"),CRAWLING("the crawling"),HANGING("the hanging");
	private String descriptions;
	private Shrubbery(String descriptions){
		this.descriptions=descriptions;
	}
	public String geDescriptions(){return descriptions;}
	private void sel(Enum s){
		for(Enum e:s.getClass().getEnumConstants()){
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		for(Shrubbery s:Shrubbery.values())
			System.out.println(s+" :"+s.geDescriptions());
	EnumSet<Shrubbery> pos=EnumSet.noneOf(Shrubbery.class);
	pos.add(GROUND);
	System.out.println(pos);
		
	}
}
