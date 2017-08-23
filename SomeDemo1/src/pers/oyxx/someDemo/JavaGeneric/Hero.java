package pers.oyxx.someDemo.JavaGeneric;

public class Hero {
	public String name;
	public float hp;
	
	public Hero(){
		
	}
	public Hero(String name){
		this.name=name;
	}
	
	@Override
	public String toString(){
		return name;
	}
}
