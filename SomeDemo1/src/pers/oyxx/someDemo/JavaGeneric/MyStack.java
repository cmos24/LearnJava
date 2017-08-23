package pers.oyxx.someDemo.JavaGeneric;

import java.util.LinkedList;

import pers.oyxx.someDemo.CollectionFramework.Hero;


//支持泛型的Stack
public class MyStack<T> {
	/*
	 * 设计一个支持泛型的栈MyStack 设计这个类的时候，在类的声明上，加上一个<T>，表示该类支持泛型。
	 * T是type的缩写，也可以使用任何其他的合法的变量，比如A,B,X都可以，但是一般约定成俗使用T，代表类型。
	 */
	LinkedList<T> values=new LinkedList<T>();
	
	//入栈
	public void push(T t){
		values.add(t);
	}
	//查看
	public T peek(){
		return values.getLast();
	}
	//出栈
	public T pull(){
		return values.removeLast();
	}
	
	public static void main(String[] args){
		//在声明这个Stack的时候使用泛型<Hero>就表示该Stack只能放Hero
		MyStack<Hero> heroStack=new MyStack <Hero>();
		heroStack.push(new Hero("hero0"));
		//不能放其他东西
		//heroStack.push(new Item());
	}
}
