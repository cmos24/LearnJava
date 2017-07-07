import pers.oyxx.someDemo.ClassandProject.FUNoverload;
import pers.oyxx.someDemo.ClassandProject.HeroExample;
import pers.oyxx.someDemo.ClassandProject.TransferParameters;
import pers.oyxx.someDemo.ClassandProject.hungrySingleClass;
import pers.oyxx.someDemo.ClassandProject.lazySingleClass;
import pers.oyxx.someDemo.String.MyStringBuffer;

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

		// MyStringBuffer myStringBuffer = new MyStringBuffer("abc");
		// // myStringBuffer.append('d');
		// myStringBuffer.insert(0, "123");
		// System.out.println(new String(myStringBuffer.value));

		// 函数重载
		// FUNoverload fol1 = new FUNoverload();
		// FUNoverload fol2 = new FUNoverload('0');
		// FUNoverload fol3 = new FUNoverload("a", "b", "c");

		// 参数类型参数传输传输
		// TransferParameters teemo = new TransferParameters("提莫",383);
		// int xueping = 100;//血瓶，其值是100
		// //提莫通过这个血瓶回血
		// teemo.huixue(xueping);
		// System.out.println(xueping);//这里xueping的值不会变成0因为在方法内，无法修改方法外的基本类型参数，传进来的参数出了方法的作用域就失效了

		// 类类型参数传输&构造函数和构造块的执行顺序（构造块先执行）
		// HeroExample teemo = new HeroExample("提莫", 383);
		// HeroExample glren = new HeroExample();
		// teemo.hp = teemo.hp - 400; // 受到400伤害，挂了
		// teemo.revive(teemo);// 复活
		// System.out.println(teemo.hp); // 并没有变回383，还是减少400之后的数值
		// System.out.println(HeroExample.copyright);

		// 饿汉单例模式
		hungrySingleClass hsc1 = hungrySingleClass.getinstance();
		hungrySingleClass hsc2 = hungrySingleClass.getinstance();
		System.out.println(hsc1 == hsc2);// 两个引用指向同一个（唯一的）对象，所以true

		// 懒汉单例模式
		lazySingleClass lsc1 = lazySingleClass.getInstance();
		lazySingleClass lsc2 = lazySingleClass.getInstance();
		System.out.println(lsc1 == lsc2);// 两个引用指向同一个（唯一的）对象，所以true
	}

}
