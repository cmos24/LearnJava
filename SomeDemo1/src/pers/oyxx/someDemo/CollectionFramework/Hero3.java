package pers.oyxx.someDemo.CollectionFramework;

//ʹHero��ʵ��Comparable�ӿ�
public class Hero3 implements Comparable<Hero3> {
	/*
	 * ʹHero��ʵ��Comparable�ӿ� ���������ṩ�Ƚ��㷨
	 * Collections.sort�����㹻����Ϣ���������ˣ�Ҳ��������ṩ�Ƚ���Comparator
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
