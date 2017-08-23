package pers.oyxx.someDemo.JavaGeneric;

import java.util.LinkedList;

import pers.oyxx.someDemo.CollectionFramework.Hero;


//֧�ַ��͵�Stack
public class MyStack<T> {
	/*
	 * ���һ��֧�ַ��͵�ջMyStack ���������ʱ������������ϣ�����һ��<T>����ʾ����֧�ַ��͡�
	 * T��type����д��Ҳ����ʹ���κ������ĺϷ��ı���������A,B,X�����ԣ�����һ��Լ������ʹ��T���������͡�
	 */
	LinkedList<T> values=new LinkedList<T>();
	
	//��ջ
	public void push(T t){
		values.add(t);
	}
	//�鿴
	public T peek(){
		return values.getLast();
	}
	//��ջ
	public T pull(){
		return values.removeLast();
	}
	
	public static void main(String[] args){
		//���������Stack��ʱ��ʹ�÷���<Hero>�ͱ�ʾ��Stackֻ�ܷ�Hero
		MyStack<Hero> heroStack=new MyStack <Hero>();
		heroStack.push(new Hero("hero0"));
		//���ܷ���������
		//heroStack.push(new Item());
	}
}
