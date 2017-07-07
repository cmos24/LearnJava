package pers.oyxx.someDemo.ClassandProject;

// 方法重载
public class FUNoverload {
	public FUNoverload() {
		System.out.println("这是无参构造函数");
	}

	public FUNoverload(char c) {
		this();//调用构造函数只能用this()而不能用函数名,而且只能在构造函数的第一行里面调用
		System.out.println("有参构造函数1:" + c);
	}

	public FUNoverload(String... c) {// 可变数量的参数,在方法里,使用操作数组的方式处理多个参数
		System.out.println("有参构造函数2:");
		for(int i=0;i<c.length;i++){
			System.out.print(" "+c[i]);
		}		
	}
	
}
