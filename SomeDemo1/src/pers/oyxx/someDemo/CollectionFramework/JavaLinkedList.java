package pers.oyxx.someDemo.CollectionFramework;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*序列分先进先出FIFO,先进后出FILO 
FIFO在Java中又叫Queue 队列 
FILO在Java中又叫Stack 栈*/

//其他集合-LinkedList
public class JavaLinkedList {

	public static void main(String[] args) {
		// 示例 1 : 双向链表 - Deque
		// LinkedList是一个双向链表结构的list
		//LinkedList<Hero> ll = new LinkedList<Hero>();
		Deque<Hero> ll = new LinkedList<Hero>();//这样写也行，因为示例里是用到双向链表接口的功能
		// 所以可以很方便的在头部和尾部插入数据
		// 在最后插入新的Hero对象
		ll.addLast(new Hero("hero1"));
		ll.addLast(new Hero("hero2"));
		ll.addLast(new Hero("hero3"));

		// 在最前面插入新的英雄
		ll.addFirst(new Hero("heroX"));
		System.out.println(ll);

		// 查看最前面的英雄
		System.out.println("最前面的英雄" + ll.getFirst());
		// 查看最后面的英雄
		System.out.println("最后面的英雄：" + ll.getLast());

		// 查看不会导致英雄被删除
		System.out.println(ll);
		// 取出最前面的英雄
		System.out.println(ll.removeFirst());

		// 取出最后面的英雄
		System.out.println(ll.removeLast());

		// 查看会导致英雄被删除
		System.out.println(ll);

		// 示例 2 : 队列 - Queue
		/*LinkedList 除了实现了List和Deque外，还实现了Queue接口(队列)。
		Queue是先进先出队列 FIFO，常用方法：
		offer 在最后添加元素
		poll 取出第一个元素
		peek 查看第一个元素*/
		
		//和ArrayList一样，LinkedList也实现了List接口
		List ll2=new LinkedList<Hero>();
		
		//所不同的是LinkedList还实现了Deque，进而还实现了Queue这个接口
		//Queue代表FIFO先进先出的队列
		Queue<Hero> q=new LinkedList<Hero>();
		//加在队列的最后面
		System.out.println("初始化队列：  \t");
		q.offer(new Hero("hero1"));
		q.offer(new Hero("hero2"));
		q.offer(new Hero("hero3"));
		q.offer(new Hero("hero4"));
		
		System.out.println(q);
		System.out.println("把第一个元素poll()出来： \t");
		//取出第一个Hero，FIFO先进先出
		Hero h=q.poll();
		System.out.println(h);
		System.out.println("取出第一个元素后的队列：	\t");
		System.out.println(q);
		
		//把第一个拿出来看一看，但是不会从队列中取出来
		h=q.peek();
		System.out.println("查看peek()得到的第一个元素");
		System.out.println(h);
		System.out.println("查看并不会导致第一个元素被取出来");
		System.out.println(q);

		
		
	}

}
