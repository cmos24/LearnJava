package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Collections
public class JavaCollections {
	//Collections��һ���࣬�����Ĺ�����,����ͬArrays������Ĺ�����
	public static void main(String[] args) {
		//���� 1 : ��ת-reverse ʹList�е����ݷ�����ת
		List<Integer> numbers=new ArrayList<Integer>();
		
		for(int i=0;i<10;i++){
			numbers.add(i);
		}
		System.out.println("�����е�����");
		System.out.println(numbers);
		
		Collections.reverse(numbers);
		System.out.println("��ת�������");
		System.out.println(numbers);
		
		//���� 2 : ����-shuffle ����List�����ݵ�˳��
		Collections.shuffle(numbers);
		System.out.println("�����������");
		System.out.println(numbers);
		
		//���� 3 : ����-sort ��List�е����ݽ�������
		Collections.sort(numbers);
		System.out.println("����������");
		System.out.println(numbers);
		
		//���� 4 : ����-swap �����������ݵ�λ��
		Collections.swap(numbers, 0, 5);
		System.out.println("�����±�0��5��Ԫ��֮�������");
		System.out.println(numbers);
		
		// ���� 5 : ����-rotate ��List�е����ݣ����ҹ���ָ����λ�ĳ���
		Collections.rotate(numbers, -2);
		System.out.println("�Ѽ����������2λ֮�������");
		System.out.println(numbers);
		
		//���� 6 : �̰߳�ȫ��-synchronizedList �ѷ��̰߳�ȫ��Listת��Ϊ�̰߳�ȫ��List��
		List<Integer> num=new ArrayList<Integer>();
		System.out.println("�ѷ��̰߳�ȫ��Listת�����̰߳�ȫ��");
		List<Integer> synchronizedNumbers=(List<Integer>)Collections.synchronizedList(num);
		
	}
}
