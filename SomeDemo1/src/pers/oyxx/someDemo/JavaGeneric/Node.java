package pers.oyxx.someDemo.JavaGeneric;

import java.util.ArrayList;
import java.util.List;

//֧�ַ��͵Ķ����������Ѷ������е�Node�࣬�����֧�ַ���
public class Node<T> {
	public Node<T> leftNode;// ���ӽڵ�
	public Node<T> rightNode;// ���ӽڵ�
	public T value;// ֵ

	// ��������
	public void add(T t) {
		// ����ڵ�û��ֵ�͸�ֵ������ڵ�
		if (null == value) {
			value = t;
		} else {
			// ����ڵ���ֵ���жϲ����ֵ�ͽڵ��ֵ�ĸ���
			if ((Integer) t <= (Integer) value) {
				if (null == leftNode)
					leftNode = new Node<T>();
				leftNode.add(t);
			} else {
				if (null == rightNode) {
					rightNode = new Node<T>();
					rightNode.add(t);
				}
			}
		}
	}

	// ����������нڵ�
	public List<T> values() {
		List<T> values = new ArrayList<>();
		// ��ڵ�ı������
		if (null != leftNode) {
			values.addAll(leftNode.values());
		}
		// ��ǰ�ڵ�
		values.add(value);
		// �ҽڵ�ı������
		if (null != rightNode) {
			values.addAll(rightNode.values());
		}
		return values;
	}

	public static void main(String[] args) {
		int[] randoms = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
		Node<Integer> root = new Node<Integer>();
		for (int number : randoms) {
			root.add(number);
		}
		System.out.println(root.values());

		/*
		 * ���������ķ����и��׶ˣ��ڱȽϵ�ʱ�򣬷���T��ת��Ϊ��Integer���д�С�Ƚϡ����仰˵�����д�ɷ�Integer���ͣ�
		 * �ͻ��������ת���쳣
		 * 
		 * new Node<Hero>
		 * 
		 * 
		 * �������Ľ������Ҫ�õ������ ? extendsģʽ
		 */

	}
}
