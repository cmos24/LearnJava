package pers.oyxx.someDemo.CollectionFramework;

public class Item implements Flag{
	String name;
	int price;
	
	public Item(){
		
	}
	
	//提供一个初始化name的构造方法
	public Item(String name){
		this.name=name;
	}
	public void effect(){
		System.out.println("物品使用后，可以产生效果");
	}
	public String toString(){
		return name;
	}
}
