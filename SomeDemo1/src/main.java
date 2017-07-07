import pers.oyxx.someDemo.Other.*;
import pers.oyxx.someDemo.String.*;
import pers.oyxx.someDemo.Array.*;

public class main {

	public static void main(String[] args) throws Exception {

		// //输出5位随机验证码
		// StringDemo stringdemo = new StringDemo();
		// String YanZhengMa=stringdemo.get5randomString();
		// System.out.println("验证码："+YanZhengMa);
		// outputYZMpng.createImage(YanZhengMa,"C:/Users/pre/Desktop/验证码.png");
		//
		// //对字符串数组按首字母排序
		// String[] randomStringGroup=stringdemo.getrandomStringGroup();
		// stringdemo.rankStringGroup(randomStringGroup);

		// 从控制台输入数字相加
		// OperationSymbol OS = new OperationSymbol();
		// //OS.add();
		// OS.TernaryOperator();

		// 1~20之间的两数相除的黄金分割数
		// ControlFlow CF=new ControlFlow();
		//// CF.getGoldenSectionNum(1,20);
		//// CF.getNarcissusNumber1();//得到水仙花数
		// CF.getNarcissusNumber2();

		// 对数组进行排序
		// pers.oyxx.someDemo.Array.sort Sort = new
		// pers.oyxx.someDemo.Array.sort();
		// // Sort.SelectionSort();// 选择排序法
		// //Sort.BubbleSort();// 冒泡排序法
		// Sort.forEX();

		// 复制数组
		// copy Copy = new copy();
		// //Copy.copyArray();
		// Copy.mergeRandomArrays();

		// 基本类型装箱拆箱
		// NumAndString nas =new NumAndString();
		// nas.BasetoClass();//手动 基本类型转封装类
		// nas.ClasstoBase();//手动 封装类转基本类型
		// nas.INTminmax();//int最大值最小值
		// nas.NUMtoString();//数字和字符串互转

		// outputFormat opf = new outputFormat();
		// opf.outputFormatTest();// 格式输出
		// // opf.fillWords();

		MyStringBuffer myStringBuffer = new MyStringBuffer("abc");
		// myStringBuffer.append('d');
		myStringBuffer.insert(0, "123");
		System.out.println(new String(myStringBuffer.value));

	}

}
