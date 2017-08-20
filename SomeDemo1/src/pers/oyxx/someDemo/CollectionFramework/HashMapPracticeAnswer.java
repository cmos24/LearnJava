package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//HashMap练习-查找内容性能比较
public class HashMapPracticeAnswer {
	/*
	 * 准备一个ArrayList其中存放3000000(三百万个)Hero对象，其名称是随机的,格式是hero-[4位随机数] 
	 * hero-3229
	 * hero-6232 
	 * hero-9365 ...
	 * 
	 * 因为总数很大，所以几乎每种都有重复，把名字叫做 hero-5555的所有对象找出来 要求使用两种办法来寻找 1.
	 * 不使用HashMap，直接使用for循环找出来，并统计花费的时间 2. 借助HashMap，找出结果，并统计花费的时间
	 */

	public static void main(String[] args) {
		List<Hero> hs = new ArrayList<>();
		System.out.println("初始化开始");
		for (int i = 0; i < 3000000; i++) {
			Hero h = new Hero("hero-" + random());
			hs.add(h);
		}
		// 名字作为key
		// 名字相同的hero，放在一个List中，作为value
		HashMap<String, List<Hero>> heroMap = new HashMap();
		for (Hero h : hs) {
			List<Hero> list = heroMap.get(h.name);
			//如果HashMap里面没有某个英雄名对应的List的话就新建一个List加进去
			if (list == null) {
				list = new ArrayList<>();
				heroMap.put(h.name, list);
			}
			//如果有对应某个英雄名的这样一个List就把它取出来，将同名的Hero对象加进去
			list.add(h);
		}
		HashMap<String,List<Hero>> herosMap=new HashMap<String,List<Hero>>();
		for(Hero h:hs){
			List<Hero> list1=herosMap.get(h.name);
			
		}
		
		System.out.println("初始化结束");
		System.out.println("开始查找");
		findByIteration(hs);
		findByMap(heroMap);

	}

	private static List<Hero> findByMap(HashMap<String, List<Hero>> m) {
		long start = System.currentTimeMillis();
		List<Hero> result = m.get("hero-5555");
		long end = System.currentTimeMillis();
		System.out.printf("通过map查找，一共找到%d个英雄，耗时%d 毫秒%n", result.size(), end - start);
		return result;
	}

	private static List<Hero> findByIteration(List<Hero> hs) {
		long start = System.currentTimeMillis();
		List<Hero> result = new ArrayList<>();
		for (Hero h : hs) {
			if (h.name.equals("hero-5555")) {
				result.add(h);
			}
		}
		long end = System.currentTimeMillis();
		System.out.printf("通过for查找，一共找到%d个英雄，耗时%d 毫秒%n", result.size(), end - start);
		return result;
	}

	public static int random() {
		return ((int) (Math.random() * 9000) + 1000);
	}
}
