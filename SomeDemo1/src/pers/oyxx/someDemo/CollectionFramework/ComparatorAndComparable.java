package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

// JAVA COMPARATOR��COMPARABLE �Ƚ���
public class ComparatorAndComparable {
	public static void main(String[] args) {
		// ���� 1 : Comparator
		/*
		 * ����Hero���������� name,hp,damage
		 * һ�������зŴ��10��Hero,ͨ��Collections.sort����10����������
		 * ��ô������hpС�ķ�ǰ�棿����damageС�ķ�ǰ�棿Collections.sortҲ�޷�ȷ�� ����Ҫָ�����װ����������Խ�������
		 * �������Ҫ�ṩһ��Comparator������ν�����������֮��Ĵ�С�Ƚ�
		 */
		Random r = new Random();
		List<Hero2> heros = new ArrayList<Hero2>();
		for (int i = 0; i < 10; i++) {
			// ͨ�����ֵʵ����hero��hp��damage
			heros.add(new Hero2("hero" + i, r.nextFloat() * 100, r.nextInt(100)));
		}
		System.out.println("��ʼ����ļ���");
		System.out.println(heros);

		// ֱ�ӵ���Collections.sort()����ֱ��������ΪHero2�м�������
		// ���װ����������Խ��бȽϣ�CollectionsҲ��֪������ȷ��������û����
		// Collections.sort(heros);

		// ����Comparator��ָ���Ƚϵ��㷨
		Comparator<Hero2> c = new Comparator<Hero2>() {
			@Override
			public int compare(Hero2 h1, Hero2 h2) {// �������������͵Ĳ���
				// ����hp��������
				if (h1.hp >= h2.hp)
					return 1;// ������ʾh1Ҫ��h2��
				else
					return -1;
			}
		};
		Collections.sort(heros, c);// �Ƚ������÷���Ҫ�û��ṩ�Ƚ�����sort����
		System.out.println("����Ѫ�������ļ��ϣ�");
		System.out.println(heros);

		// ���� 2 : Comparable
		/*
		 * ʹHero��ʵ��Comparable�ӿ� ���������ṩ�Ƚ��㷨
		 * Collections.sort�����㹻����Ϣ���������ˣ�Ҳ��������ṩ�Ƚ���Comparator
		 */
		List<Hero3> heros1=new ArrayList<Hero3>();
		//ͨ�����ֵʵ����hero��hp��damage
		for(int i=0;i<10;i++){
			heros1.add(new Hero3("hero"+i,r.nextFloat()*100,r.nextInt(100)));
		}
		System.out.println("��ʼ����ļ��ϣ�");
		System.out.println(heros1);
		
		//Hero3��ʵ����Comparable����ֻ���Ƚ���Ϣ
		//Cellections.sort()ֱ�ӽ���������������Comparator
		Collections.sort(heros1);
		System.out.println("����Hero3��damage���Դ�С���������Ľ����");
		System.out.println(heros1);
	}
}
