package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;

//ArrayList�ĳ��÷���
public class FrequentlyUsedFunction {
	public static void main(String[] args) {
		// ���� 1 : ����
		ArrayList heros1 = new ArrayList();
		// ��5������Ӽ��ϵ�β��������뵽������
		for (int i = 0; i < 5; i++) {
			heros1.add(new Hero("Hero" + i));
		}
		// �Ѷ�����ӵ�����ָ����λ����
		Hero specialHero = new Hero("special hero");
		heros1.add(3, specialHero);
		System.out.println(heros1.toString());// ��������ÿ��Ԫ�ض�ִ��toString
		
		ArrayList heros2=new ArrayList();
		heros2.add(new Hero("hero11"));
		heros2.add(new Hero("hero12"));

		// ���� 2 : �ж��Ƿ����
		System.out.println(heros1);// �͵�17�еĴ�ӡ����Ч����һ����
		// �ж�һ�������Ƿ���������
		// �жϱ�׼�� �Ƿ���ͬһ�����󣬶�����name�Ƿ���ͬ
		System.out.print("��Ȼһ���µĶ�������Ҳ�� hero 1������contains�ķ�����:");
		System.out.println(heros1.contains(new Hero("hero 1")));
		System.out.print("����specialHero���жϣ�contains�ķ�����:");
		System.out.println(heros1.contains(specialHero));

		// ���� 3 : ��ȡָ��λ�õĶ���
		// ��ȡָ��λ�õĶ���
		System.out.println(heros1.get(5));
		// ��������˷�Χ����Ȼ�ᱨ��
		// System.out.println(heros1.get(6));

		// ���� 4 : ��ȡ����������λ��
		// indexOf�����ж�һ��������ArrayList��������λ��
		// ��containsһ�����жϵı�׼�Ƕ������Ƿ���ͬ�����Ƕ����name
		System.out.println(heros1);
		System.out.println("specialHero������λ��:" + heros1.indexOf(specialHero));
		System.out.println("�µ�Ӣ�ۣ�����������\"hero 1\"������λ��:" + heros1.indexOf(new Hero("Hero 1")));

		// ���� 6 : �滻
		System.out.println(heros1);
		System.out.println("���±���5��Ԫ�أ��滻Ϊ\"hero 5\"");
		heros1.set(5, new Hero("hero 233"));
		// heros1.set(heros1.indexOf(specialHero), new
		// Hero("hero233"));//Ҳ��������д�滻ָ����Ԫ��
		System.out.println(heros1);

		// ���� 7 : ��ȡ��С
		// size ���ڻ�ȡArrayList�Ĵ�С
		System.out.println("��ȡArrayList�Ĵ�С��");
		System.out.println(heros1.size());

		// ���� 8 : ת��Ϊ����
		/*
		 * toArray()���԰�һ��ArrayList����ת��Ϊ���顣
		 * ��Ҫע����ǣ����Ҫת��Ϊһ��Hero���飬��ô��Ҫ����һ��Hero�������͵Ķ����toArray()��
		 * ����toArray������֪������ϣ��ת��Ϊ�������͵����飬����ֻ��ת��ΪObject����
		 */
		System.out.println(heros1);
		Hero[] hs = (Hero[]) heros1.toArray(new Hero[] {});
		// Hero[] hs=(Hero[]) heros1.toArray();//����д�ᱨ����ΪtoArray()��֪��Ҫת����ʲô����
		System.out.println("ת��������飺" + hs);

		// ���� 5 : ɾ��
		// remove���ڰѶ����ArrayList��ɾ��
		// remove���Ը����±�ɾ��ArrayList��Ԫ��
		System.out.println(heros1);
		heros1.remove(2);
		System.out.println("ɾ���±���2�Ķ���");
		System.out.println(heros1);
		System.out.println("ɾ��special hero");
		heros1.remove(specialHero);
		System.out.println(heros1);
		
		//���� 9 : ����һ���������ж��󶼼ӽ���
		System.out.println("heros2�е�Ԫ�أ�"+heros2);
		heros1.addAll(heros2);
		System.out.println("����heros2���ϵ�heros1֮��"+heros1);
		
		//���� 10 : ���
		System.out.println("heros2�е�Ԫ�أ�"+heros2);
		System.out.println("ʹ��clear���");
		heros2.clear();
		System.out.println("��պ��heros2��"+heros2);

	}// main����β��
}
