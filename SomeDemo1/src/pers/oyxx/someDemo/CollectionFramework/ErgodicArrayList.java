package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//遍历ArrayList的三种方法
public class ErgodicArrayList {

	public static void main(String[] args) {
		// 将5个Hero放入容器
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero" + i));
		}
		// 步骤 1 : 用for循环遍历
		/*for(int i=0;i<heros.size();i++){
			System.out.println(heros.get(i));
		}*/
		//增强型for循环
		for (Hero h : heros) {
			System.out.println(h.name);
		}
		// 步骤2 : 迭代器遍历
		System.out.println("--------使用while的iterator-------");
		Iterator<Hero> it = heros.iterator();
		// 从最开始的位置判断"下一个"位置是否有数据
		// 如果有就通过next取出来，并且把指针向下移动
		// 直达"下一个"位置没有数据
		while (it.hasNext()) {
			Hero h = it.next();
			System.out.println(h);
		}
		// 迭代器for的写法
		System.out.println("--------使用for的iterator-------");
		for (Iterator<Hero> iterator = heros.iterator(); iterator.hasNext();) {
			Hero hero = (Hero) iterator.next();
			System.out.println(hero);
		}

		// 步骤 3 : 用增强型for循环
		/*
		 * 使用增强型for循环可以非常方便的遍历ArrayList中的元素，这是很多开发人员的首选。
		 * 
		 * 不过增强型for循环也有不足： 无法用来进行ArrayList的初始化
		 * 无法得知当前是第几个元素了，当需要只打印单数元素的时候，就做不到了。 必须再自定下标变量。
		 * 
		 * 同步骤1
		 */

	}

}
