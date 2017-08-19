package pers.oyxx.someDemo.CollectionFramework;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

//��ϰ-�Ƚ�ð�ݷ���ѡ���Լ��������������������
public class SomeSortCompare {
	/* ����4����������Ȼ���÷ֱ���ð�ݷ���ѡ�񷨣�������3�������㷨�������򣬱Ƚ����ָ��� */
	
	// ð�ݷ�-����
	public static int[] bubbleSort(int[] random){
		int[] result=random;
		int temp;
		for(int i=0;i<result.length;i++){
			for(int j=0;j<(result.length-i-1);j++){
				if(result[j]>result[j+1]){
					temp=result[j];
					result[j]=result[j+1];
					result[j+1]=temp;
				}
			}
		}
		return result;
	}
	//ѡ��-����
	public static int[] selectSort(int[] random){
		int[] result=random;
		int temp;
		for(int i=0;i<result.length-1;i++){
			for(int j=i+1;j<result.length;j++){
				if(result[i]>result[j]){
					temp=result[i];
					result[i]=result[j];
					result[j]=temp;
				}
			}
		}
		return result;
	}
		
	public static void main(String[] args) {
		Random r=new Random();
		int[] random=new int[40000];
		for(int i=0;i<random.length;i++){
			random[i]=r.nextInt(40000);
		}
		//int[] random = new int[] { 56, 7, 13, 44, 29, 87 };		
		Date d1;
		Date d2;
		System.out.println("��ʼ�����");
        System.out.println("�������ֱ���3���㷨��������");
		
        int[] use3sort;
        use3sort=Arrays.copyOf(random,random.length);
        
		d1=new Date();
		long t1=System.currentTimeMillis();
		int[] result1=bubbleSort(use3sort);
		long t2=System.currentTimeMillis();
		d2=new Date();
		System.out.println("ð���������ĵ�ʱ�䣺"+(d2.getTime()-d1.getTime()));
		System.out.println("ð���������ĵ�ʱ�䣺"+(t2-t1));
		/*System.out.print("ð������Ľ����");
		for(int each:result1){
			System.out.print(each+",");
		}*/
		System.out.println();
		
        use3sort=Arrays.copyOf(random,random.length);
		
		d1=new Date();
		t1=System.currentTimeMillis();
		int[] result2=selectSort(use3sort);
		t2=System.currentTimeMillis();
		d2=new Date();
		System.out.println("ѡ���������ĵ�ʱ�䣺"+(d2.getTime()-d1.getTime()));
		System.out.println("ѡ���������ĵ�ʱ�䣺"+(t2-t1));
		/*System.out.print("ѡ������Ľ����");
		for(int each:result2){
			System.out.print(each+",");
		}*/
		System.out.println();
		
		use3sort=Arrays.copyOf(random,random.length);
		
		d1=new Date();
		BinaryTree roots=new BinaryTree();		
		for(int each:use3sort){
			roots.add(each);
		}
		//System.out.println("����������Ľ����"+roots.values());
		roots.values();
		d2=new Date();
		System.out.println("�������������ĵ�ʱ�䣺"+(d2.getTime()-d1.getTime()));
		
		System.out.println("ѡ���ð������Ľ�������Ƿ�һ����"+Arrays.equals(result1,result2));
		
	}//main����β��
}
