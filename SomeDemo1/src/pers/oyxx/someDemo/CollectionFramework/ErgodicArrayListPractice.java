package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.List;

/*���ȳ�ʼ��һ��Hero���ϣ������100��Hero�������Ʒֱ��Ǵ�
hero 0
hero 1
hero 2
...
hero 99.

ͨ���������ֶΣ�ɾ�������ֱ����8�ı����Ķ���*/
//ArrayLis������ϰ-ɾ��ArrayList�е�����
public class ErgodicArrayListPractice {

	public static void main(String[] args) {
		/*
		 * �����ϰ�Ŀ����ǣ����ܹ���ʹ��Iterator����ǿforѭ���������ݵ�ͬʱ��ɾ�����ݣ�
		 * ������׳�ConcurrentModificationException
		 * 
		 * ��ͨ��forҲ���ԣ��������׻���
		 * ����취����׼��һ����ʱ������ר������������Ҫɾ���Ķ��� Ȼ����ɾ��
		 */
		List<Hero> heros = new ArrayList<Hero>();

		// ��100��Hero��������
		for (int i = 0; i < 100; i++) {
			heros.add(new Hero("hero name " + i));
		}
		/*
		 * for (int id = 0; id < 100; id++) { if (0 == id % 8) {
		 * heros.remove(id); } }
		 */// Ϊʲô������д���ᱨ�� java.lang.IndexOutOfBoundsException: Index: 96, Size: 88
		System.out.println("ɾ��ǰ�ļ�����Ԫ�أ�"+heros);
		
		// ׼��һ��������ר������װҪɾ���Ķ��� 
		List<Hero> deletingHeros = new ArrayList<>();

		for (Hero h : heros) {
			int id = Integer.parseInt(h.name.substring(10));
			if (0 == id % 8)
				deletingHeros.add(h);
		}
		for (Hero h : deletingHeros) {
			heros.remove(h);
		} 
		// heros.removeAll(deletingHeros);// ֱ��ͨ��removeAllɾ�����Hero����
		System.out.println("ɾ����ļ�����Ԫ�أ�"+heros);

	}

}
