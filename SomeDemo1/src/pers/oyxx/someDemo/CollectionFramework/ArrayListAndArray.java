package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;

/*
 * ����ĳ��ȴ���֮����ǹ̶��ģ�����һ������Ϊ10�������ֻ�ܷ���10�����������͵�Ԫ�أ����˷Ų��£������˷ѣ����������ľ�����
 * Ϊ�˽������ľ����ԣ�����������ĸ�� �������������� ArrayList ����������"capacity"�����Ŷ�������ӣ��Զ�����ֻ��Ҫ����������������Ӣ�ۼ��ɣ����õ��Ļ��������ı߽����⡣
 */
//����ͼ�������������
public class ArrayListAndArray {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		//������ArrayList�����ڴ�Ŷ���
		ArrayList heros=new ArrayList();
		heros.add(new Hero("����"));
		System.out.println(heros.size());
		
		//����������"capacity"�����Ŷ�������Ӷ��Զ�����
		//ֻҪ���ϵ��������������Ӣ�ۼ��ɣ����õ��Ļ��������߽������
		heros.add(new Hero("��Ī"));
		System.out.println(heros.size());
	}
}
