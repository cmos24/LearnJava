package pers.oyxx.someDemo.Array;

public class sort {

	// 选择法排序
	public void SelectionSort() {
		int[] array = new int[] { 18, 62, 68, 82, 65, 9 };
		int temp;
		for (int i = 0; i < array.length; i++) {
			System.out.println("数组第" + (i + 1) + "个元素=" + array[i]);
		}
		System.out.println("==========选择排序==========");
		for (int j = 0; j < (array.length - 1); j++) {
			for (int k = 1 + j; k < array.length; k++) {
				if (array[j] > array[k]) {
					temp = array[j];
					array[j] = array[k];
					array[k] = temp;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println("排序后数组第" + (i + 1) + "个元素=" + array[i]);
		}
	}

	// 冒泡法排序
	public void BubbleSort() {
		int[] array = new int[] { 18, 62, 68, 82, 65, 9 };
		int temp;
		for (int i = 0; i < array.length; i++) {
			System.out.println("数组第" + (i + 1) + "个元素=" + array[i]);
		}
		System.out.println("==========冒泡排序==========");
		for (int j = 0; j < (array.length - 1); j++) {
			for (int k = 0; k < (array.length - 1 - j); k++) {
				if (array[k] > array[k + 1]) {
					temp = array[k];
					array[k] = array[k + 1];
					array[k + 1] = temp;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println("排序后数组第" + (i + 1) + "个元素=" + array[i]);
		}
	}

	// 增强型for循环
	public void forEX() {
		int[] array = new int[] { 18, 62, 68, 82, 65, 9 };
		int max = 0;
		for (int each : array) {
			System.out.print(each + ",");
			if (each > max) {
				max = each;
			}
		}
		System.out.println("数组中的最大值=" + max);
	}
}// 类尾部
