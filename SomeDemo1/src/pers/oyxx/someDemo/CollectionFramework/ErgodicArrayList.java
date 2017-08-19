package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//����ArrayList�����ַ���
public class ErgodicArrayList {

	public static void main(String[] args) {
		// ��5��Hero��������
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero" + i));
		}
		// ���� 1 : ��forѭ������
		/*for(int i=0;i<heros.size();i++){
			System.out.println(heros.get(i));
		}*/
		//��ǿ��forѭ��
		for (Hero h : heros) {
			System.out.println(h.name);
		}
		// ����2 : ����������
		System.out.println("--------ʹ��while��iterator-------");
		Iterator<Hero> it = heros.iterator();
		// ���ʼ��λ���ж�"��һ��"λ���Ƿ�������
		// ����о�ͨ��nextȡ���������Ұ�ָ�������ƶ�
		// ֱ��"��һ��"λ��û������
		while (it.hasNext()) {
			Hero h = it.next();
			System.out.println(h);
		}
		// ������for��д��
		System.out.println("--------ʹ��for��iterator-------");
		for (Iterator<Hero> iterator = heros.iterator(); iterator.hasNext();) {
			Hero hero = (Hero) iterator.next();
			System.out.println(hero);
		}

		// ���� 3 : ����ǿ��forѭ��
		/*
		 * ʹ����ǿ��forѭ�����Էǳ�����ı���ArrayList�е�Ԫ�أ����Ǻܶ࿪����Ա����ѡ��
		 * 
		 * ������ǿ��forѭ��Ҳ�в��㣺 �޷���������ArrayList�ĳ�ʼ��
		 * �޷���֪��ǰ�ǵڼ���Ԫ���ˣ�����Ҫֻ��ӡ����Ԫ�ص�ʱ�򣬾��������ˡ� �������Զ��±������
		 * 
		 * ͬ����1
		 */

	}

}
