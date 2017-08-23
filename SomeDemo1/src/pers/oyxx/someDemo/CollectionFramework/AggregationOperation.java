package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Comparator;

//集合框架——聚合
public class AggregationOperation {
	//聚合操作
	public static void main(String[] args) {
		Random r=new Random();
		List<Hero2> heros=new ArrayList<Hero2>();
		for(int i=0;i<10;i++){
			heros.add(new Hero2("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
		System.out.println("初始化集合后的数据（最后一个数据重复）");
		System.out.println(heros);
		
		//传统方式
		Collections.sort(heros,new Comparator<Hero2>(){//匿名类，比较器Comparator是抽象类，在这里使用的时候顺便把方法实现了
			@Override
			public int compare(Hero2 h1,Hero2 h2){
				return (int)(h2.hp-h1.hp);
			}
		});
		System.out.println("排序后的集合数据：");
		System.out.println(heros);
		System.out.println("通过传统方式找出来hp第三高的英雄是：");
		System.out.println(heros.get(2));
		
		//用聚合的方式处理
		/*String name =heros
            .stream()
            .sorted((h1,h2)->h1.hp>h2.hp?-1:1)
            .skip(2)
            .map(h->h.getName())
            .findFirst()
            .get();
 
        System.out.println("通过聚合操作找出来的hp第三高的英雄名称是:" + name);*/
	}
}
