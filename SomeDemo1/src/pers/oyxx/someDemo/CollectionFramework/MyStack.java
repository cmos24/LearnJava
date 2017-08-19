package pers.oyxx.someDemo.CollectionFramework;

import java.util.LinkedList;

/*��FIFO(�����ȳ���)�������Ƶ�һ�����ݽṹ��FILO������ջStack
���ݽӿ�Stack ��
ʵ���ࣺMyStack
 
public class MyStack implements Stack

�������ջ�У�ѹ��5��Ӣ�ۣ����ŵ���5��Ӣ��

�ٽ���һ��ջ: ջ�Ľṹ���������������ӵ�һ��������ӵ��ӵ����ͷ����������棬����ǹ��ʱ��ֻ�ܴ�������ȡ�ӵ���*/
//ʹ��LinkedListʵ��Stackջ
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
			System.out.println("��ջ��ѹ��hero:"+i);
		}
		//�������һ��Hero����
		Hero lastHero=heroStack.pull();
		System.out.println("�������һ��Hero����"+lastHero);
		//������һ��Hero����
		Hero lastHero2=heroStack.peek();
		System.out.println("������һ��Hero����"+lastHero2);
		
		System.out.println("����heroStack���е�Ԫ�أ�"+heroStack.heros);
	}
}
