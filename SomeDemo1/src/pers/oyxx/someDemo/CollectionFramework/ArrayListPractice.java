package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;

//ArrayList��ϰ
public class ArrayListPractice {

	public static void main(String[] args) {
		// ��ϰ-�ж��Ƿ���ͬ
		/* �������Ҫ�жϼ������Ƿ����һ�� name���� "hero1"�Ķ���Ӧ����ô���� */
		ArrayList heros1 = new ArrayList();
		for (int i = 0; i < 5; i++) {
			heros1.add(new Hero("hero" + i));
		}
		System.out.println("�Ƿ����name����hero1�Ķ���"+objectContains(heros1,"hero1"));
	}

	/**
	 * �жϼ������Ƿ����һ�� name����ָ���ַ����Ķ���
	 * @param al
	 * 	Ҫ�жϵļ���
	 * @param name
	 * 	ָ���ַ���
	 * @return
	 * 	�Ƿ����name����ָ���ַ����Ķ���
	 */
	public static boolean objectContains(ArrayList al, String name) {
		Hero h=null;
		for(int i=0;i<al.size();i++){
			h=(Hero)al.get(i);
			if(name.equals(h.name)){
				return true;
			}
		}
		return false;
	}
}
