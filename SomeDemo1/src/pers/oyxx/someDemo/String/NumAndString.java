package pers.oyxx.someDemo.String;

public class NumAndString {

	// 基本类型 转 封装类
	public void BasetoClass() {
		int i = 24;
		Integer integer = new Integer(i);
		System.out.println("转换后封装类的值=" + integer.intValue());
	}

	// 封装类 转 基本类型
	public void ClasstoBase() {
		Integer integer = new Integer(66);
		int i = integer.intValue();
		System.out.println("转换后基本类型的值=" + i);
	}

	// 装箱拆箱
	public void autoClassBase() {
		int i1 = 24;
		Integer integer1 = new Integer(0);
		integer1 = i1;// 装箱——基本类型直接自动转换成封装类

		int i2 = 0;
		Integer integer2 = new Integer(66);
		i2 = integer2;// 拆箱——封装类直接自动转换成基本类型
	}

	// int的最大值和最小值
	public void INTminmax() {
		System.out.println("int最大值" + Integer.MAX_VALUE);
		System.out.println("int最小值" + Integer.MIN_VALUE);
	}

	// 数字、字符串互转
	public void NUMtoString() {
		//数字转字符串
		int i1 = 24;
		String str1 = String.valueOf(i1);//方法1：使用String类的静态方法valueOf
		
		Integer integer1 =i1;
		String str2 =integer1.toString();//方法2：先将int装箱为对象，调用integer对象的toString()函数
		
		//字符串转数字
		String str3="66";
		int i2=Integer.parseInt(str3);//调用Integer的静态方法parseInt()
		
		//浮点数和字符串互转
		double dou=3.14;
		String str4=String.valueOf(dou);
		String str5=Double.toString(dou);
		System.out.println("浮点数转换成字符串="+str4+str5);
		
		dou=Double.parseDouble("3.14");
		System.out.println("字符串转换成浮点数="+dou);
		
		
	}
	
}
