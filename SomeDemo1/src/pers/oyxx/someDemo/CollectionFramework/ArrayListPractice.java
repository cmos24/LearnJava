package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;

//ArrayList练习
public class ArrayListPractice {

	public static void main(String[] args) {
		// 练习-判断是否相同
		/* 如果就是要判断集合里是否存在一个 name等于 "hero1"的对象，应该怎么做？ */
		ArrayList heros1 = new ArrayList();
		for (int i = 0; i < 5; i++) {
			heros1.add(new Hero("hero" + i));
		}
		System.out.println("是否存在name等于hero1的对象："+objectContains(heros1,"hero1"));
	}

	/**
	 * 判断集合里是否存在一个 name等于指定字符串的对象
	 * @param al
	 * 	要判断的集合
	 * @param name
	 * 	指定字符串
	 * @return
	 * 	是否存在name等于指定字符串的对象
	 */
	public static boolean objectContains(ArrayList al, String name) {
		Hero h=null;
		for(int i=0;i<al.size();i++){
			h=(Hero)al.get(i);
			if(name.equals(h.name)){
				return true;
			}
		}
		return false;
	}
}
