package pers.oyxx.someDemo.JavaReflect;

/*���� 1 : Hero.java
Ϊ�˷������ԣ���name�޸�Ϊpublic��
����private���εĳ�Ա����Ҫʹ��setAccessible(true)���ܷ��ʺ��޸ġ����ڴ�֪ʶ�����ۡ�*/
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
		System.out.println(this.name+"���ڹ���"+h.getName());
	}

}
