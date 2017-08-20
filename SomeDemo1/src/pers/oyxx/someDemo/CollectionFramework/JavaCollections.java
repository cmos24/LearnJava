package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Collections
public class JavaCollections {
	//Collections是一个类，容器的工具类,就如同Arrays是数组的工具类
	public static void main(String[] args) {
		//步骤 1 : 反转-reverse 使List中的数据发生反转
		List<Integer> numbers=new ArrayList<Integer>();
		
		for(int i=0;i<10;i++){
			numbers.add(i);
		}
		System.out.println("集合中的数据");
		System.out.println(numbers);
		
		Collections.reverse(numbers);
		System.out.println("翻转后的数据");
		System.out.println(numbers);
		
		//步骤 2 : 混淆-shuffle 混淆List中数据的顺序
		Collections.shuffle(numbers);
		System.out.println("混淆后的数据");
		System.out.println(numbers);
		
		//步骤 3 : 排序-sort 对List中的数据进行排序
		Collections.sort(numbers);
		System.out.println("排序后的数据");
		System.out.println(numbers);
		
		//步骤 4 : 交换-swap 交换两个数据的位置
		Collections.swap(numbers, 0, 5);
		System.out.println("交换下标0和5的元素之后的数据");
		System.out.println(numbers);
		
		// 步骤 5 : 滚动-rotate 把List中的数据，向右滚动指定单位的长度
		Collections.rotate(numbers, -2);
		System.out.println("把集合向左滚动2位之后的数据");
		System.out.println(numbers);
		
		//步骤 6 : 线程安全化-synchronizedList 把非线程安全的List转换为线程安全的List。
		List<Integer> num=new ArrayList<Integer>();
		System.out.println("把非线程安全的List转换成线程安全的");
		List<Integer> synchronizedNumbers=(List<Integer>)Collections.synchronizedList(num);
		
	}
}
