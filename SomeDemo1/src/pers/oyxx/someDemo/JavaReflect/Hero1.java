package pers.oyxx.someDemo.JavaReflect;

/*步骤 1 : Hero.java
为了访问属性，把name修改为public。
对于private修饰的成员，需要使用setAccessible(true)才能访问和修改。不在此知识点讨论。*/
public class Hero1 {
	private String name;
	public float hp;
	public int damage;
	public int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hero1() {

	}

	public Hero1(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hero [name=" + this.name + "]";
	}
	public boolean isDead(){
		return false;
	}
	public void attackHero(Hero1 h){
		System.out.println(this.name+"正在攻击"+h.getName());
	}

}
