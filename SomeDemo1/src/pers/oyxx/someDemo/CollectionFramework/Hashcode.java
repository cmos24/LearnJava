package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//Hashcode原理详解
public class Hashcode {
	public static void main(String[] args){
		//步骤 1 : List查找的低效率
		/*假设在List中存放着无重复名称，没有顺序的2000000个Hero
		要把名字叫做“hero 1000000”的对象找出来
		List的做法是对每一个进行挨个遍历，直到找到名字叫做“hero 1000000”的英雄。
		最差的情况下，需要遍历和比较2000000次，才能找到对应的英雄。
		测试逻辑：
		1. 初始化2000000个对象到ArrayList中
		2. 打乱容器中的数据顺序
		3. 进行10次查询，统计每一次消耗的时间
		不同计算机的配置情况下，所花的事件是有区别的。 在本机上，花掉的时间大概是600毫秒左右*/
		List<Hero> heros1=new ArrayList<Hero>();
		//初始化List
		for(int i=0;i<2000000;i++){
			heros1.add(new Hero("Hero"+i));
		}
		//进行10次查找，观察大体的平均值
		for(int i=0;i<10;i++){
			//打乱容器中元素的顺序
			Collections.shuffle(heros1);
			long startTime=System.currentTimeMillis();
			for(Hero h:heros1){
				if(h.name.equals("Hero1000000")){
					System.out.println("在List中找到了"+h);
					break;
				}
			}
			long endTime=System.currentTimeMillis();
			System.out.println("消耗"+(endTime-startTime)+"毫秒");
		}
		
		//步骤 2 : HashMap的性能表现
		/*使用HashMap 做同样的查找
		1. 初始化2000000个对象到HashMap中。
		2. 进行10次查询
		3. 统计每一次的查询消耗的时间
		可以观察到，几乎不花时间，花费的时间在1毫秒以内*/
		HashMap<Integer,Hero> heros2=new HashMap<Integer,Hero>();
		//初始化HashMap
		for(int i=0;i<2000000;i++){
			heros2.put(i, new Hero("hero"+i));
		}
		//进行10次查询
		for(int i=0;i<10;i++){
			long startTime=System.currentTimeMillis();
			Hero hero=heros2.get(1000000);
			System.out.println("在HashMap中找到了"+hero);
			long endTime=System.currentTimeMillis();
			System.out.println("消耗"+(endTime-startTime)+"毫秒");
		}
		
		
		
		
	}//main函数尾部
}
