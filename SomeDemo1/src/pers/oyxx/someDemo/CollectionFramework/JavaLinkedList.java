package pers.oyxx.someDemo.CollectionFramework;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*���з��Ƚ��ȳ�FIFO,�Ƚ����FILO 
FIFO��Java���ֽ�Queue ���� 
FILO��Java���ֽ�Stack ջ*/

//��������-LinkedList
public class JavaLinkedList {

	public static void main(String[] args) {
		// ʾ�� 1 : ˫������ - Deque
		// LinkedList��һ��˫������ṹ��list
		//LinkedList<Hero> ll = new LinkedList<Hero>();
		Deque<Hero> ll = new LinkedList<Hero>();//����дҲ�У���Ϊʾ�������õ�˫������ӿڵĹ���
		// ���Կ��Ժܷ������ͷ����β����������
		// ���������µ�Hero����
		ll.addLast(new Hero("hero1"));
		ll.addLast(new Hero("hero2"));
		ll.addLast(new Hero("hero3"));

		// ����ǰ������µ�Ӣ��
		ll.addFirst(new Hero("heroX"));
		System.out.println(ll);

		// �鿴��ǰ���Ӣ��
		System.out.println("��ǰ���Ӣ��" + ll.getFirst());
		// �鿴������Ӣ��
		System.out.println("������Ӣ�ۣ�" + ll.getLast());

		// �鿴���ᵼ��Ӣ�۱�ɾ��
		System.out.println(ll);
		// ȡ����ǰ���Ӣ��
		System.out.println(ll.removeFirst());

		// ȡ��������Ӣ��
		System.out.println(ll.removeLast());

		// �鿴�ᵼ��Ӣ�۱�ɾ��
		System.out.println(ll);

		// ʾ�� 2 : ���� - Queue
		/*LinkedList ����ʵ����List��Deque�⣬��ʵ����Queue�ӿ�(����)��
		Queue���Ƚ��ȳ����� FIFO�����÷�����
		offer ��������Ԫ��
		poll ȡ����һ��Ԫ��
		peek �鿴��һ��Ԫ��*/
		
		//��ArrayListһ����LinkedListҲʵ����List�ӿ�
		List ll2=new LinkedList<Hero>();
		
		//����ͬ����LinkedList��ʵ����Deque��������ʵ����Queue����ӿ�
		//Queue����FIFO�Ƚ��ȳ��Ķ���
		Queue<Hero> q=new LinkedList<Hero>();
		//���ڶ��е������
		System.out.println("��ʼ�����У�  \t");
		q.offer(new Hero("hero1"));
		q.offer(new Hero("hero2"));
		q.offer(new Hero("hero3"));
		q.offer(new Hero("hero4"));
		
		System.out.println(q);
		System.out.println("�ѵ�һ��Ԫ��poll()������ \t");
		//ȡ����һ��Hero��FIFO�Ƚ��ȳ�
		Hero h=q.poll();
		System.out.println(h);
		System.out.println("ȡ����һ��Ԫ�غ�Ķ��У�	\t");
		System.out.println(q);
		
		//�ѵ�һ���ó�����һ�������ǲ���Ӷ�����ȡ����
		h=q.peek();
		System.out.println("�鿴peek()�õ��ĵ�һ��Ԫ��");
		System.out.println(h);
		System.out.println("�鿴�����ᵼ�µ�һ��Ԫ�ر�ȡ����");
		System.out.println(q);

		
		
	}

}
