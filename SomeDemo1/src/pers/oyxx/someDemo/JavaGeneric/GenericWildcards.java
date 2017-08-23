package pers.oyxx.someDemo.JavaGeneric;

import java.util.ArrayList;

//����ͨ���
public class GenericWildcards {

	public static void main(String[] args) {
		// ʾ�� 1 : ? extends
		/*
		 * ArrayList heroList<? extends Hero> ��ʾ����һ��Hero���ͻ��������෺�� heroList
		 * �ķ��Ϳ�����Hero heroList �ķ��Ϳ�����APHero heroList �ķ��Ϳ�����ADHero ����
		 * ����ȷ����ǣ���heroListȡ�����Ķ���һ���ǿ���ת�ͳ�Hero��
		 * 
		 * ���ǣ�����������Ŷ�������Ϊ ��APHero�Ͳ�����<ADHero> ��ADHero�ֲ�����<APHero>
		 */
		ArrayList<APHero> apHeroList1 = new ArrayList<APHero>();
		apHeroList1.add(new APHero("aphero1"));
		ArrayList<? extends Hero> heroList1 = apHeroList1;// ? extends
															// Hero��ʾ����һ��Hero�����෺��
		// heroList �ķ��Ϳ�����Hero
		// heroList �ķ��Ϳ�����APHero
		// heroList �ķ��Ϳ�����ADHero

		System.out.println("���������ó�Ԫ����һ������ץ����Hero�ģ���Ϊ��Hero�����෺�ͣ�" + heroList1.get(0));
		// ���ǲ���������Ŷ�������Ϊ����֪���Ž�ȥ����APHero����ADHero����������
		// heroList.add(new ADHero("adhero1"));

		/*
		 * ʾ�� 2 : ? super ArrayList heroList<? super Hero> ��ʾ����һ��Hero���ͻ����丸�෺��
		 * heroList�ķ��Ϳ�����Hero heroList�ķ��Ϳ�����Object
		 * 
		 * �������������Hero�Լ�Hero������ ����ȡ�����з��գ���Ϊ��ȷ��ȡ������Hero����Object
		 */
		ArrayList<? super Hero> heroList2 = new ArrayList<Object>();
		// ? super Hero ��ʾ heroList�ķ�����Hero�����丸�෺��

		// heroList �ķ��Ϳ�����Hero
		// heroList �ķ��Ϳ�����Object
		// ���ԾͿ��Բ���Hero
		heroList2.add(new Hero("hero2"));
		heroList2.add(new APHero("aphero2"));
		heroList2.add(new ADHero("adhero2"));
		// ���ǲ��ܴ�����ȡ���ݳ�������Ϊ�䷺�Ϳ�����Object,��Object��ǿתHero��ʧ��
		// Hero h=heroList2.get(0);

		/*
		 * ʾ�� 3 : ����ͨ���? ����ͨ���? �������ⷺ�� ��Ȼ?�������ⷺ�ͣ���ô���仰˵���������ʲô���Ͷ��п���
		 * 
		 * ����ֻ����Object����ʽȡ���� ���Ҳ���������Ŷ�����Ϊ��֪��������һ��ʲô���͵�����
		 */
		ArrayList<APHero> apHeroList = new ArrayList<APHero>();

		// ?����ͨ�������ʾ���ⷺ��
		ArrayList<?> generalList = apHeroList;

		// ?��ȱ��1�� ��Ȼ?�������ⷺ�ͣ���ô���仰˵����Ͳ�֪���������������ʲô����
		// ����ֻ����Object����ʽȡ����
		Object o = generalList.get(0);

		// ?��ȱ��2�� ��Ȼ?�������ⷺ�ͣ���ô���п�����Hero,Ҳ�п�����Item
		// ���ԣ������ֶ����ȥ�����з��գ������ʲôʲô���͵Ķ��󣬶����ܷŽ�ȥ
		// generalList.add(new Item()); //������� ��Ϊ?�������ⷺ�ͣ����п��ܲ���Item
		// generalList.add(new Hero()); //������� ��Ϊ?�������ⷺ�ͣ����п��ܲ���Hero
		// generalList.add(new APHero()); //������� ��Ϊ?�������ⷺ�ͣ����п��ܲ���APHero

		/*
		 * ʾ�� 4 : �ܽ� ���ϣ��ֻȡ���������룬��ʹ��? extends Hero ���ϣ��ֻ���룬��ȡ������ʹ��? super Hero
		 * ���ϣ�������ܲ��룬����ȡ�����Ͳ�Ҫ��ͨ�����
		 */

	}

}
