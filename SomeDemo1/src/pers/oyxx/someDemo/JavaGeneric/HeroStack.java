package pers.oyxx.someDemo.JavaGeneric;

import java.util.LinkedList;

import pers.oyxx.someDemo.CollectionFramework.Hero;

//不支持泛型的Stack
public class HeroStack {
	/*
	 * 以Stack栈为例子，如果不使用泛型 当需要一个只能放Hero的栈的时候，就需要设计一个HeroStack
	 * 当需要一个只能放Item的栈的时候，就需要一个ItemStack
	 */
	LinkedList<Hero> heros=new LinkedList<Hero>();
	
	//入栈
	public void push(Hero h){
		heros.addLast(h);
	}
	//查看栈顶元素
	public Hero peek(){
		return heros.getLast();
	}
	//出栈
	public Hero pull(){
		return heros.removeLast();
	}
	
	public static void main(String[] args) {
		HeroStack heroStack=new HeroStack();
		for(int i=0;i<5;i++){
			System.out.println("压入 hero"+i);
			heroStack.push(new Hero("hero"+i));
		}
		for(int i=0;i<5;i++){
			Hero h=heroStack.pull();
			System.out.println("弹出"+h);
		}
		
	}
}
