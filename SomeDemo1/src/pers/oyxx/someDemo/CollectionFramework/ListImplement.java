package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.List;

//ARRAYLIST��LIST�ӿ�
public class ListImplement {

	public static void main(String[] args) {
		// ���� 1 : ArrayList��List
		/*
		 * ArrayListʵ���˽ӿ�List ������д�������������Ϊ�ӿ�List����
		 * ע�⣺��java.util.List,������java.awt.List
		 */
		List heros = new ArrayList();
		heros.add(new Hero("����"));
		System.out.println(heros);

		// ���� 2 : List�ӿڵķ���
		/*
		 * ��ΪArrayListʵ����List�ӿڣ�����List�ӿڵķ���ArrayList��ʵ���ˡ� ��ArrayList
		 * ���÷����½�����ϸ�Ľ��⣬�ڴ˲���׸��
		 */
	}

}
