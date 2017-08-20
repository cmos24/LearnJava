package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Collections��ϰ-ͳ�Ƹ���
public class CollectionsPractise {
	/*
	 * ���ȳ�ʼ��һ��List,������10��ֵ��0-9�� Ȼ�󲻶ϵ�shuffle��ֱ��ǰ3λ���� 3 1 4 shuffle 1000,000
	 * �Σ�ͳ�Ƴ��ֵĸ���
	 */
	public static void main(String[] args) {
		// ��ʼ��
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			numbers.add(i);
		}
		System.out.println(numbers);
		// ����shuffle
		boolean flag = false;
		int s = 0;
		int per = 0;// ����ǰ��λ��3 1 4�������Ĵ���
		for (int i = 0; i < 1000000; i++) {
			Collections.shuffle(numbers);// ����
			for (int j = 0; j < 3; j++) {// �ж��Ƿ��������
				flag = false;
				flag |= (3 == numbers.get(j));
				flag |= (1 == numbers.get(j));
				flag |= (4 == numbers.get(j));
				if (flag) {
					s++;
				}
			}
			if (3 == s) {//���ǰ������������
				per++;
			}
			s=0;

		}
		double gailv=(double)per/1000000;
		System.out.printf("����Ϊ���ٷ�֮%.4f",gailv*100);
	}

}
