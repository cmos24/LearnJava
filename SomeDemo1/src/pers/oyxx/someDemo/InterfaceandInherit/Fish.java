package pers.oyxx.someDemo.InterfaceandInherit;

/*1. 创建Fish类，它继承Animal类
2. 重写Animal的walk方法以表明鱼不能走且没有腿。
3. 实现Pet接口
4. 无参构造方法
5. 提供一个private 的name属性*/

public class Fish extends AbstractAnimal implements Pet{
	private String name;	

	public Fish() {
		super(0);
	}

	public void walk(){
		System.out.println("鱼不能走而且没有腿");
	}
	
	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void play() {
		System.out.println("鱼喜欢吐气泡玩");
	}

	@Override
	public void eat() {
		System.out.println("鱼吃小鱼");
	}
	
}
