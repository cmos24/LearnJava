package pers.oyxx.someDemo.Array;

public class copy {

	// ��������
	public void copyArray() {
		int[] a = new int[] { 18, 62, 68, 82, 65, 9 };
		int[] b = new int[3];
		// ���Ԫ�ظ�ֵ
		for (int i = 0; i < b.length; i++) {
			b[i] = a[i];
		}

		// �ø������麯��
		System.arraycopy(a, 0, b, 0, b.length);
		for (int i = 0; i < b.length; i++) {
			System.out.println("����b��Ԫ��" + (i + 1) + "��" + b[i]);
		}
	}
	
	//�ϲ�������������������
	public void mergeRandomArrays(){
		int[] arrayA=new int[(int) (Math.random()*5+5)];//��������Ϊ5-10���������
		int[] arrayB=new int[(int) (Math.random()*5+5)];
		int[] arrayC=new int[arrayA.length+arrayB.length];
		for(int i=0;i<arrayA.length;i++){//��������������
			arrayA[i]=(int)(Math.random()*100);
		}
		for(int i=0;i<arrayB.length;i++){//��������������
			arrayB[i]=(int)(Math.random()*100);
		}
		System.arraycopy(arrayA, 0, arrayC, 0, arrayA.length);
		System.arraycopy(arrayB, 0, arrayC, arrayA.length, arrayB.length);//����arrayA.length����+1,��Ϊ�����0��ʼ����,ֱ��д�����൱���Ѿ�+1��,arrayA��arrayB������β�غ�
		
		for (int i = 0; i < arrayA.length; i++) {
			System.out.println("����A��Ԫ��" + (i + 1) + "��" + arrayA[i]);
		}
		for (int i = 0; i < arrayB.length; i++) {
			System.out.println("����B��Ԫ��" + (i + 1) + "��" + arrayB[i]);
		}
		for (int i = 0; i < arrayC.length; i++) {
			System.out.println("����C��Ԫ��" + (i + 1) + "��" + arrayC[i]);
		}
		
	}
}
