package pers.oyxx.someDemo.Array;

public class sort {

	// ѡ������
	public void SelectionSort() {
		int[] array = new int[] { 18, 62, 68, 82, 65, 9 };
		int temp;
		for (int i = 0; i < array.length; i++) {
			System.out.println("�����" + (i + 1) + "��Ԫ��=" + array[i]);
		}
		System.out.println("==========ѡ������==========");
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
			System.out.println("����������" + (i + 1) + "��Ԫ��=" + array[i]);
		}
	}

	// ð�ݷ�����
	public void BubbleSort() {
		int[] array = new int[] { 18, 62, 68, 82, 65, 9 };
		int temp;
		for (int i = 0; i < array.length; i++) {
			System.out.println("�����" + (i + 1) + "��Ԫ��=" + array[i]);
		}
		System.out.println("==========ð������==========");
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
			System.out.println("����������" + (i + 1) + "��Ԫ��=" + array[i]);
		}
	}

	// ��ǿ��forѭ��
	public void forEX() {
		int[] array = new int[] { 18, 62, 68, 82, 65, 9 };
		int max = 0;
		for (int each : array) {
			System.out.print(each + ",");
			if (each > max) {
				max = each;
			}
		}
		System.out.println("�����е����ֵ=" + max);
	}
}// ��β��
