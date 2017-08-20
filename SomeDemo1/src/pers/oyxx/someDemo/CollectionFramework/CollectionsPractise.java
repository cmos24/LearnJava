package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Collections练习-统计概率
public class CollectionsPractise {
	/*
	 * 首先初始化一个List,长度是10，值是0-9。 然后不断的shuffle，直到前3位出现 3 1 4 shuffle 1000,000
	 * 次，统计出现的概率
	 */
	public static void main(String[] args) {
		// 初始化
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			numbers.add(i);
		}
		System.out.println(numbers);
		// 进行shuffle
		boolean flag = false;
		int s = 0;
		int per = 0;// 符合前三位是3 1 4的条件的次数
		for (int i = 0; i < 1000000; i++) {
			Collections.shuffle(numbers);// 打乱
			for (int j = 0; j < 3; j++) {// 判断是否符合条件
				flag = false;
				flag |= (3 == numbers.get(j));
				flag |= (1 == numbers.get(j));
				flag |= (4 == numbers.get(j));
				if (flag) {
					s++;
				}
			}
			if (3 == s) {//如果前三个数都符合
				per++;
			}
			s=0;

		}
		double gailv=(double)per/1000000;
		System.out.printf("概率为：百分之%.4f",gailv*100);
	}

}
