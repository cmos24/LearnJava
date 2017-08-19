package pers.oyxx.someDemo.CollectionFramework;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

//练习-比较冒泡法，选择法以及二叉树排序的性能区别
public class SomeSortCompare {
	/* 创建4万个随机数，然后用分别用冒泡法，选择法，二叉树3种排序算法进行排序，比较哪种更快 */
	
	// 冒泡法-升序
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
	//选择法-升序
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
		System.out.println("初始化完毕");
        System.out.println("接下来分别用3种算法进行排序");
		
        int[] use3sort;
        use3sort=Arrays.copyOf(random,random.length);
        
		d1=new Date();
		long t1=System.currentTimeMillis();
		int[] result1=bubbleSort(use3sort);
		long t2=System.currentTimeMillis();
		d2=new Date();
		System.out.println("冒泡排序消耗的时间："+(d2.getTime()-d1.getTime()));
		System.out.println("冒泡排序消耗的时间："+(t2-t1));
		/*System.out.print("冒泡排序的结果：");
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
		System.out.println("选择排序消耗的时间："+(d2.getTime()-d1.getTime()));
		System.out.println("选择排序消耗的时间："+(t2-t1));
		/*System.out.print("选择排序的结果：");
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
		//System.out.println("二叉树排序的结果："+roots.values());
		roots.values();
		d2=new Date();
		System.out.println("二叉树排序消耗的时间："+(d2.getTime()-d1.getTime()));
		
		System.out.println("选择和冒泡排序的结果内容是否一样："+Arrays.equals(result1,result2));
		
	}//main函数尾部
}
