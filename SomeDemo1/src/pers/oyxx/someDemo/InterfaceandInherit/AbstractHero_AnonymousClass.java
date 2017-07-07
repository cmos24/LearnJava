package pers.oyxx.someDemo.InterfaceandInherit;

/*匿名类指的是在声明一个类的同时实例化它，使代码更加简洁精练
通常情况下，要使用一个接口或者抽象类，都必须创建一个子类

有的时候，为了快速使用，直接实例化一个抽象类，并“当场”实现其抽象方法。
既然实现了抽象方法，那么就是一个新的类，只是这个类，没有命名。
这样的类，叫做匿名类*/

//Hero匿名类版本
public abstract class AbstractHero_AnonymousClass {
	String name; // 姓名

	float hp; // 血量

	float armor; // 护甲

	int moveSpeed; // 移动速度

	public abstract void attack();
	
	public static void main(String[] args){	
		ADHero adh=new ADHero();
		adh.physicAttack();
		System.out.println(adh);//通过打印adh，可以看到adh这个对象属于ADHero类
		
		AbstractHero_AnonymousClass hero=new AbstractHero_AnonymousClass() {
			//当场实现attack方法
			@Override
			public void attack() {
				System.out.println("new AttackType");
			}
		};
		hero.attack();
		//通过打印hero，可以看到hero这个对象属于AbstractHero_AnonymousClass$1这么一个系统自动分配的类名
		System.out.println(hero);
				
	}

}
