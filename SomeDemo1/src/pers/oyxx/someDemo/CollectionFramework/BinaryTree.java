package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.List;

//ʾ�� 1 : ����������
/*
 * �������ɸ��ֽڵ���� �������ص㣺 ÿ���ڵ㶼���������ӽڵ㣬���ӽڵ� ÿһ���ڵ㶼��һ��ֵ
 */

// ʾ�� 2 : ����������-��������
/*
 * ����ͨ��������������10��������������� 67,7,30,73,10,0,78,81,10,74 ����ĵ�һ�������ǰ����ݲ��뵽�ö�������
 * ��������߼��ǣ�С����ͬ�ķ���ߣ���ķ��ұ�
 */
//������
public class BinaryTree {
	// ���ӽڵ�
	public BinaryTree leftNode;
	// ���ӽڵ�
	public BinaryTree rightNode;
	// ֵ
	public Object value;

	// ��������
	public void add(Object v) {
		// �����ǰ�ڵ�û��ֵ���Ͱ����ݷ��ڵ�ǰ�ڵ���
		if (null == value) {
			value = v;
			// �����ǰ�ڵ���ֵ���ͽ����жϣ�������ֵ�뵱ǰֵ�Ĵ�С��ϵ
		} else { // ������ֵ�ȵ�ǰֵС������ͬ
			if ((Integer) v - ((Integer) value) <= 0) {
				if (null == leftNode)
					leftNode = new BinaryTree();
				leftNode.add(v);
				
			} else { // ������ֵ���ȵ�ǰ��ֵ��
				if (null == rightNode)
					rightNode = new BinaryTree();
				rightNode.add(v);
				
			}
		}
	}

	// ʾ�� 3 : ����������-����
	/*
	 * ͨ����һ������Ĳ�����Ϊ��ʵ���ϣ����ݾ��Ѿ��ź����ˡ� ������Ҫ�����ǿ�������Щ�Ѿ��ź�������ݣ����������ǳ��õ�List�����������ʽ
	 */
	// ����������еĽڵ㣬�����ǷŽ�һ��List����������
	public List<Object> values() {
		List<Object> values = new ArrayList<Object>();
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
		int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };

		BinaryTree roots = new BinaryTree();
		for (int number : randoms) {
			roots.add(number);
		}
		System.out.println("�����������ɹ�");
		System.out.println(roots.values());

	}
}
