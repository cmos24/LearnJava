package pers.oyxx.someDemo.InterfaceandInherit;

public class ADHero extends Hero implements AD {
	/*
	 * 作为子类，无论如何 都会调用父类的构造方法。 默认情况下，会调用父类的无参的构造方法。 但是，当父类没有无参构造方法
	 * 的时候(提供了有参构造方法，并且不显示提供无参构造方法)，子类就会抛出异常，因为它尝试去调用父类的无参构造方法。
	 * 这个时候，必须通过super去调用父类声明的，存在的，有参的构造方法
	 */
	public ADHero() {
		super("");
		System.out.println("ADHero的无参构造方法");
	}

	public ADHero(String str) {
		super(str);// 父类的构造函数必须放在子类的构造函数第一行
		System.out.println("ADHero的一个有参构造方法" + str);
	}

	@Override
	public void physicAttack() {
		System.out.println("do physicAttack");
	}

	// 调用父类属性
	public String getName0() {
		return super.name;
	}

	public String getName1() {
		return this.name;
	}

}
