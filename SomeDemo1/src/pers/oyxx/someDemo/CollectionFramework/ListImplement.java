package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.List;

//ARRAYLIST与LIST接口
public class ListImplement {

	public static void main(String[] args) {
		// 步骤 1 : ArrayList和List
		/*
		 * ArrayList实现了接口List 常见的写法会把引用声明为接口List类型
		 * 注意：是java.util.List,而不是java.awt.List
		 */
		List heros = new ArrayList();
		heros.add(new Hero("盖伦"));
		System.out.println(heros);

		// 步骤 2 : List接口的方法
		/*
		 * 因为ArrayList实现了List接口，所以List接口的方法ArrayList都实现了。 在ArrayList
		 * 常用方法章节有详细的讲解，在此不作赘述
		 */
	}

}
