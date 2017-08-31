package pers.oyxx.someDemo.JavaReflect;

import java.lang.reflect.Method;

//调用方法
public class CallMethod {

	public static void main(String[] args) {
		/*步骤 1 : 调用方法
		首先为Hero的name属性，增加setter和getter
		通过反射机制调用Hero的setName*/
		Hero2 h=new Hero2();
		
		try{
			//获取这个类的叫做setName，参数类型是String的方法
			Method m=h.getClass().getMethod("setName", String.class);
			//对h对象，调用这个方法
			m.invoke(h, "盖伦");
			//使用传统的方式，调用getName方法
			System.out.println(h.getName());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
