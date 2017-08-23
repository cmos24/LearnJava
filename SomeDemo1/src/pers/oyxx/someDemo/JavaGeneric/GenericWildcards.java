package pers.oyxx.someDemo.JavaGeneric;

import java.util.ArrayList;

//泛型通配符
public class GenericWildcards {

	public static void main(String[] args) {
		// 示例 1 : ? extends
		/*
		 * ArrayList heroList<? extends Hero> 表示这是一个Hero泛型或者其子类泛型 heroList
		 * 的泛型可能是Hero heroList 的泛型可能是APHero heroList 的泛型可能是ADHero 所以
		 * 可以确凿的是，从heroList取出来的对象，一定是可以转型成Hero的
		 * 
		 * 但是，不能往里面放东西，因为 放APHero就不满足<ADHero> 放ADHero又不满足<APHero>
		 */
		ArrayList<APHero> apHeroList1 = new ArrayList<APHero>();
		apHeroList1.add(new APHero("aphero1"));
		ArrayList<? extends Hero> heroList1 = apHeroList1;// ? extends
															// Hero表示这是一个Hero的子类泛型
		// heroList 的泛型可以是Hero
		// heroList 的泛型可以是APHero
		// heroList 的泛型可以是ADHero

		System.out.println("从这里面拿出元素是一定可以抓换成Hero的，因为是Hero的子类泛型：" + heroList1.get(0));
		// 但是不能往里面放东西，因为它不知道放进去的是APHero还是ADHero，会编译错误
		// heroList.add(new ADHero("adhero1"));

		/*
		 * 示例 2 : ? super ArrayList heroList<? super Hero> 表示这是一个Hero泛型或者其父类泛型
		 * heroList的泛型可能是Hero heroList的泛型可能是Object
		 * 
		 * 可以往里面插入Hero以及Hero的子类 但是取出来有风险，因为不确定取出来是Hero还是Object
		 */
		ArrayList<? super Hero> heroList2 = new ArrayList<Object>();
		// ? super Hero 表示 heroList的泛型是Hero或者其父类泛型

		// heroList 的泛型可以是Hero
		// heroList 的泛型可以是Object
		// 所以就可以插入Hero
		heroList2.add(new Hero("hero2"));
		heroList2.add(new APHero("aphero2"));
		heroList2.add(new ADHero("adhero2"));
		// 但是不能从里面取数据出来，因为其泛型可能是Object,而Object是强转Hero会失败
		// Hero h=heroList2.get(0);

		/*
		 * 示例 3 : 泛型通配符? 泛型通配符? 代表任意泛型 既然?代表任意泛型，那么换句话说，这个容器什么泛型都有可能
		 * 
		 * 所以只能以Object的形式取出来 并且不能往里面放对象，因为不知道到底是一个什么泛型的容器
		 */
		ArrayList<APHero> apHeroList = new ArrayList<APHero>();

		// ?泛型通配符，表示任意泛型
		ArrayList<?> generalList = apHeroList;

		// ?的缺陷1： 既然?代表任意泛型，那么换句话说，你就不知道这个容器里面是什么类型
		// 所以只能以Object的形式取出来
		Object o = generalList.get(0);

		// ?的缺陷2： 既然?代表任意泛型，那么既有可能是Hero,也有可能是Item
		// 所以，放哪种对象进去，都有风险，结果就什么什么类型的对象，都不能放进去
		// generalList.add(new Item()); //编译错误 因为?代表任意泛型，很有可能不是Item
		// generalList.add(new Hero()); //编译错误 因为?代表任意泛型，很有可能不是Hero
		// generalList.add(new APHero()); //编译错误 因为?代表任意泛型，很有可能不是APHero

		/*
		 * 示例 4 : 总结 如果希望只取出，不插入，就使用? extends Hero 如果希望只插入，不取出，就使用? super Hero
		 * 如果希望，又能插入，又能取出，就不要用通配符？
		 */

	}

}
