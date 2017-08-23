package pers.oyxx.someDemo.CollectionFramework;

//使Hero类实现Comparable接口
public class Hero3 implements Comparable<Hero3> {
	/*
	 * 使Hero类实现Comparable接口 在类里面提供比较算法
	 * Collections.sort就有足够的信息进行排序了，也无需额外提供比较器Comparator
	 * 
	 */
	public String name;
	public float hp;
	public int damage;

	public Hero3() {

	}

	public Hero3(String name) {
		this.name = name;
	}

	public Hero3(String name, float hp, int damage) {
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}

	@Override
	public int compareTo(Hero3 anotherHero3) {
		if (damage > anotherHero3.damage)
			return 1;
		else
			return -1;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
	}

}
