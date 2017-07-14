package pers.oyxx.someDemo.Array;

public class copy {

	// 复制数组
	public void copyArray() {
		int[] a = new int[] { 18, 62, 68, 82, 65, 9 };
		int[] b = new int[3];
		// 逐个元素赋值
		for (int i = 0; i < b.length; i++) {
			b[i] = a[i];
		}

		// 用复制数组函数
		System.arraycopy(a, 0, b, 0, b.length);
		for (int i = 0; i < b.length; i++) {
			System.out.println("数组b的元素" + (i + 1) + "：" + b[i]);
		}
	}
	
	//合并长度随机的随机数数组
	public void mergeRandomArrays(){
		int[] arrayA=new int[(int) (Math.random()*5+5)];//创建长度为5-10的随机数组
		int[] arrayB=new int[(int) (Math.random()*5+5)];
		int[] arrayC=new int[arrayA.length+arrayB.length];
		for(int i=0;i<arrayA.length;i++){//向数组填充随机数
			arrayA[i]=(int)(Math.random()*100);
		}
		for(int i=0;i<arrayB.length;i++){//向数组填充随机数
			arrayB[i]=(int)(Math.random()*100);
		}
		System.arraycopy(arrayA, 0, arrayC, 0, arrayA.length);
		System.arraycopy(arrayB, 0, arrayC, arrayA.length, arrayB.length);//这里arrayA.length不用+1,因为数组从0开始计数,直接写数字相当于已经+1了,arrayA和arrayB不会首尾重合
		
		for (int i = 0; i < arrayA.length; i++) {
			System.out.println("数组A的元素" + (i + 1) + "：" + arrayA[i]);
		}
		for (int i = 0; i < arrayB.length; i++) {
			System.out.println("数组B的元素" + (i + 1) + "：" + arrayB[i]);
		}
		for (int i = 0; i < arrayC.length; i++) {
			System.out.println("数组C的元素" + (i + 1) + "：" + arrayC[i]);
		}
		
	}
}
