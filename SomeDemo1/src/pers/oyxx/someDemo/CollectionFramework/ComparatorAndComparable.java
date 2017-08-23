package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

// JAVA COMPARATOR和COMPARABLE 比较器
public class ComparatorAndComparable {
	public static void main(String[] args) {
		// 步骤 1 : Comparator
		/*
		 * 假设Hero有三个属性 name,hp,damage
		 * 一个集合中放存放10个Hero,通过Collections.sort对这10个进行排序
		 * 那么到底是hp小的放前面？还是damage小的放前面？Collections.sort也无法确定 所以要指定到底按照哪种属性进行排序
		 * 这里就需要提供一个Comparator给定如何进行两个对象之间的大小比较
		 */
		Random r = new Random();
		List<Hero2> heros = new ArrayList<Hero2>();
		for (int i = 0; i < 10; i++) {
			// 通过随机值实例化hero的hp和damage
			heros.add(new Hero2("hero" + i, r.nextFloat() * 100, r.nextInt(100)));
		}
		System.out.println("初始化后的集合");
		System.out.println(heros);

		// 直接调用Collections.sort()会出现编译错误，因为Hero2有几个属性
		// 到底按照哪种属性进行比较，Collections也不知道，不确定，所以没法排
		// Collections.sort(heros);

		// 引入Comparator，指定比较的算法
		Comparator<Hero2> c = new Comparator<Hero2>() {
			@Override
			public int compare(Hero2 h1, Hero2 h2) {// 两个容器中类型的参数
				// 按照hp进行排序
				if (h1.hp >= h2.hp)
					return 1;// 正数表示h1要比h2大
				else
					return -1;
			}
		};
		Collections.sort(heros, c);// 比较器的用法，要用户提供比较器给sort方法
		System.out.println("按照血量排序后的集合：");
		System.out.println(heros);

		// 步骤 2 : Comparable
		/*
		 * 使Hero类实现Comparable接口 在类里面提供比较算法
		 * Collections.sort就有足够的信息进行排序了，也无需额外提供比较器Comparator
		 */
		List<Hero3> heros1=new ArrayList<Hero3>();
		//通过随机值实例化hero的hp和damage
		for(int i=0;i<10;i++){
			heros1.add(new Hero3("hero"+i,r.nextFloat()*100,r.nextInt(100)));
		}
		System.out.println("初始化后的集合：");
		System.out.println(heros1);
		
		//Hero3类实现了Comparable，即只带比较信息
		//Cellections.sort()直接进行排序，无需额外的Comparator
		Collections.sort(heros1);
		System.out.println("按照Hero3的damage属性大小进行排序后的结果：");
		System.out.println(heros1);
	}
}
