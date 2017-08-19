package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;

//ArrayList的常用方法
public class FrequentlyUsedFunction {
	public static void main(String[] args) {
		// 步骤 1 : 增加
		ArrayList heros1 = new ArrayList();
		// 把5个对象从集合的尾部逐个加入到集合中
		for (int i = 0; i < 5; i++) {
			heros1.add(new Hero("Hero" + i));
		}
		// 把对象添加到集合指定的位置中
		Hero specialHero = new Hero("special hero");
		heros1.add(3, specialHero);
		System.out.println(heros1.toString());// 将集合中每个元素都执行toString
		
		ArrayList heros2=new ArrayList();
		heros2.add(new Hero("hero11"));
		heros2.add(new Hero("hero12"));

		// 步骤 2 : 判断是否存在
		System.out.println(heros1);// 和第17行的打印代码效果是一样的
		// 判断一个对象是否在容器中
		// 判断标准： 是否是同一个对象，而不是name是否相同
		System.out.print("虽然一个新的对象名字也叫 hero 1，但是contains的返回是:");
		System.out.println(heros1.contains(new Hero("hero 1")));
		System.out.print("而对specialHero的判断，contains的返回是:");
		System.out.println(heros1.contains(specialHero));

		// 步骤 3 : 获取指定位置的对象
		// 获取指定位置的对象
		System.out.println(heros1.get(5));
		// 如果超出了范围，依然会报错
		// System.out.println(heros1.get(6));

		// 步骤 4 : 获取对象所处的位置
		// indexOf用于判断一个对象在ArrayList中所处的位置
		// 和contains一样，判断的标准是对象本身是否相同而不是对象的name
		System.out.println(heros1);
		System.out.println("specialHero所处的位置:" + heros1.indexOf(specialHero));
		System.out.println("新的英雄，但是名字是\"hero 1\"所处的位置:" + heros1.indexOf(new Hero("Hero 1")));

		// 步骤 6 : 替换
		System.out.println(heros1);
		System.out.println("把下标是5的元素，替换为\"hero 5\"");
		heros1.set(5, new Hero("hero 233"));
		// heros1.set(heros1.indexOf(specialHero), new
		// Hero("hero233"));//也可以这样写替换指定的元素
		System.out.println(heros1);

		// 步骤 7 : 获取大小
		// size 用于获取ArrayList的大小
		System.out.println("获取ArrayList的大小：");
		System.out.println(heros1.size());

		// 步骤 8 : 转换为数组
		/*
		 * toArray()可以把一个ArrayList对象转换为数组。
		 * 需要注意的是，如果要转换为一个Hero数组，那么需要传递一个Hero数组类型的对象给toArray()，
		 * 这样toArray方法才知道，你希望转换为哪种类型的数组，否则只能转换为Object数组
		 */
		System.out.println(heros1);
		Hero[] hs = (Hero[]) heros1.toArray(new Hero[] {});
		// Hero[] hs=(Hero[]) heros1.toArray();//这样写会报错因为toArray()不知道要转换成什么数组
		System.out.println("转换后的数组：" + hs);

		// 步骤 5 : 删除
		// remove用于把对象从ArrayList中删除
		// remove可以根据下标删除ArrayList的元素
		System.out.println(heros1);
		heros1.remove(2);
		System.out.println("删除下标是2的对象");
		System.out.println(heros1);
		System.out.println("删除special hero");
		heros1.remove(specialHero);
		System.out.println(heros1);
		
		//步骤 9 : 把另一个容器所有对象都加进来
		System.out.println("heros2中的元素："+heros2);
		heros1.addAll(heros2);
		System.out.println("加了heros2集合到heros1之后："+heros1);
		
		//步骤 10 : 清空
		System.out.println("heros2中的元素："+heros2);
		System.out.println("使用clear清空");
		heros2.clear();
		System.out.println("清空后的heros2："+heros2);

	}// main函数尾部
}
