package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;

/*
 * 数组的长度创建之后就是固定的，比如一个长度为10的数组就只能放下10个该数组类型的元素，多了放不下，少了浪费，这就是数组的局限性
 * 为了解决数组的局限性，引入容器类的概念。 最常见的容器类就是 ArrayList 容器的容量"capacity"会随着对象的增加，自动增长只需要不断往容器里增加英雄即可，不用担心会出现数组的边界问题。
 */
//数组和集合容器的区别
public class ArrayListAndArray {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		//容器类ArrayList，用于存放对象
		ArrayList heros=new ArrayList();
		heros.add(new Hero("盖伦"));
		System.out.println(heros.size());
		
		//容器的容量"capacity"会随着对象的增加而自动增长
		//只要不断地往容器里面添加英雄即可，不用担心会出现数组边界的问题
		heros.add(new Hero("提莫"));
		System.out.println(heros.size());
	}
}
