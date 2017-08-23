package pers.oyxx.someDemo.JavaGeneric;

import java.util.LinkedList;

import pers.oyxx.someDemo.CollectionFramework.Hero;

//��֧�ַ��͵�Stack
public class HeroStack {
	/*
	 * ��StackջΪ���ӣ������ʹ�÷��� ����Ҫһ��ֻ�ܷ�Hero��ջ��ʱ�򣬾���Ҫ���һ��HeroStack
	 * ����Ҫһ��ֻ�ܷ�Item��ջ��ʱ�򣬾���Ҫһ��ItemStack
	 */
	LinkedList<Hero> heros=new LinkedList<Hero>();
	
	//��ջ
	public void push(Hero h){
		heros.addLast(h);
	}
	//�鿴ջ��Ԫ��
	public Hero peek(){
		return heros.getLast();
	}
	//��ջ
	public Hero pull(){
		return heros.removeLast();
	}
	
	public static void main(String[] args) {
		HeroStack heroStack=new HeroStack();
		for(int i=0;i<5;i++){
			System.out.println("ѹ�� hero"+i);
			heroStack.push(new Hero("hero"+i));
		}
		for(int i=0;i<5;i++){
			Hero h=heroStack.pull();
			System.out.println("����"+h);
		}
		
	}
}
