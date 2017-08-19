package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.List;

/*
借助泛型和前面学习的面向对象的知识，设计一个ArrayList，使得这个ArrayList里，
又可以放Hero，又可以放Item,但是除了这两种对象，其他的对象都不能放*/
//练习-支持泛型的ArrayList
public class ArrayListGenericPractice {
	public static void main(String[] args) {
		/*思路：给Hero和Item一个标记作用的父类或者接口，
		 * 这样他们作为同一类型的子类就可以同时放入使用标记父类泛型的容器里了*/
		List<Flag> h=new ArrayList<Flag>();
		h.add(new Hero("寒冰"));
		h.add(new Item("电刀"));
		System.out.println(h);
	}
	
	
	
}
