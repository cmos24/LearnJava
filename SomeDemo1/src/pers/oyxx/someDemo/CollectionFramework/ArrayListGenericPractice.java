package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.List;

/*
�������ͺ�ǰ��ѧϰ����������֪ʶ�����һ��ArrayList��ʹ�����ArrayList�
�ֿ��Է�Hero���ֿ��Է�Item,���ǳ��������ֶ��������Ķ��󶼲��ܷ�*/
//��ϰ-֧�ַ��͵�ArrayList
public class ArrayListGenericPractice {
	public static void main(String[] args) {
		/*˼·����Hero��Itemһ��������õĸ�����߽ӿڣ�
		 * ����������Ϊͬһ���͵�����Ϳ���ͬʱ����ʹ�ñ�Ǹ��෺�͵���������*/
		List<Flag> h=new ArrayList<Flag>();
		h.add(new Hero("����"));
		h.add(new Item("�絶"));
		System.out.println(h);
	}
	
	
	
}
