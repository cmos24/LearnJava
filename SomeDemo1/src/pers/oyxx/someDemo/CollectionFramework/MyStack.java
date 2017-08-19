package pers.oyxx.someDemo.CollectionFramework;

import java.util.LinkedList;

/*与FIFO(先入先出的)队列类似的一种数据结构是FILO先入后出栈Stack
根据接口Stack ：
实现类：MyStack
 
public class MyStack implements Stack

并向这个栈中，压入5个英雄，接着弹出5个英雄

再解释一下栈: 栈的结构，就像给弹夹添加子弹一样，先添加的子弹，就放在了最下面，打手枪的时候，只能从最上面取子弹。*/
//使用LinkedList实现Stack栈
public class MyStack implements Stack {
	LinkedList<Hero> heros = new LinkedList<Hero>();

	@Override
	public void push(Hero h) {
		heros.addLast(h);
	}

	@Override
	public Hero pull() {
		Hero lastHero=heros.getLast();
		heros.removeLast();
		return lastHero;
	}

	@Override
	public Hero peek() {
		Hero lastHero=heros.getLast();
		return lastHero;
	}

	public static void main(String[] args) {
		MyStack heroStack=new MyStack();
		for(int i=0;i<5;i++){
			heroStack.push(new Hero("hero"+i));
			System.out.println("向栈中压入hero:"+i);
		}
		//弹出最后一个Hero对象
		Hero lastHero=heroStack.pull();
		System.out.println("弹出最后一个Hero对象："+lastHero);
		//获得最后一个Hero对象
		Hero lastHero2=heroStack.peek();
		System.out.println("获得最后一个Hero对象："+lastHero2);
		
		System.out.println("现在heroStack中有的元素："+heroStack.heros);
	}
}
