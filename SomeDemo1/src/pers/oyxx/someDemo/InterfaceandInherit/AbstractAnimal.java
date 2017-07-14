package pers.oyxx.someDemo.InterfaceandInherit;

/*1. 创建Animal类，它是所有动物的抽象父类。
2. 声明一个受保护的整数类型属性legs，它记录动物的腿的数目。
3. 定义一个受保护的构造器，用来初始化legs属性。
4. 声明抽象方法eat。
5. 声明具体方法walk来打印动物是如何行走的（包括腿的数目）。
*/

public abstract class AbstractAnimal {
	protected int legs;

	protected AbstractAnimal(int legs) {
		this.legs = legs;
	}

	public abstract void eat();
	
	public void walk(){
		System.out.println("动物行走");
	}
}
