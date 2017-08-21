package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.List;

//泛型
public class ArrayListGeneric {

	public static void main(String[] args) {
		// 步骤 1 : 泛型 Generic
		/*
		 * 不指定泛型的容器，可以存放任何类型的元素 
		 * 指定了泛型的容器，只能存放指定类型的元素以及其子类
		 */
		
		//对于不使用泛型的容器，可以往里面放英雄，也可以往里面放物品
		List<Object> heros=new ArrayList<Object>();
		
		heros.add(new Hero("盖伦"));
		
		//本来用于存放英雄的容器，现在也可以存放物品了
		heros.add(new Item("冰杖"));
		
		//对象转型会出现问题
		Hero h1=(Hero)heros.get(0);
		//尤其是在容器里放的对象太多的时候，就记不清楚哪个位置放的是哪种类型的对象了
		//Hero h2=(Hero)heros.get(1);//这行会报错，因为集合heros中下标为1的元素不是Hero类型的
		
		//引入泛型Generic
		//声明容器的时候，就指定这种容器只能放Hero类型的对象，放其他的就会出错
		List<Hero> genericheros=new ArrayList<Hero>();
		genericheros.add(new Hero("盖伦"));
		//如果不是Hero类型，根本就放不进去
        //genericheros.add(new Item("冰杖"));
		
		//除此之外还能存放Hero的子类，因为子类转换成父类是一定能成功的？
		//genericheros.add(new APHero());
		
		//而且在取出数据的时候，不需要再进行转型了，因为里面放的肯定是Hero或者他的子类
		Hero h=genericheros.get(0);
		
		//步骤 2 : 泛型的简写
		/*为了不使编译器出现警告，需要前后都使用泛型，像这样：		 
		List<Hero> genericheros = new ArrayList<Hero>();		 
		不过JDK7提供了一个可以略微减少代码量的泛型简写方式		 
		List<Hero> genericheros2 = new ArrayList<>();*/
		List<Hero> genericheros1=new ArrayList<Hero>();
		List<Hero> genericheros2=new ArrayList<>();
		
		
		
			
	}

}
