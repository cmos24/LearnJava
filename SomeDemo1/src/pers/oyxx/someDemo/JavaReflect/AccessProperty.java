package pers.oyxx.someDemo.JavaReflect;

import java.lang.reflect.Field;

//访问属性-通过反射机制修改对象的属性
public class AccessProperty {

	public static void main(String[] args) {
		Hero1 h=new Hero1();
		//使用传统方式修改name的值为gareen
		h.setName("gareen");
		
		try {
			//获取类Hero1的叫name的字段
			Field f1=h.getClass().getDeclaredField("name");//getDeclaredField是可以获取一个类的所有字段.getField只能获取类的public 字段.
			//修改这个字段的值
			f1.setAccessible(true);//name是private修饰的，添加 f1.setAccessible(true);方法设置可写
			f1.set(h, "teemo");
			//打印被修改后的值
			System.out.println(h.getName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*getField和getDeclaredField的区别
		这两个方法都是用于获取字段
		getField 只能获取public的，包括从父类继承来的字段。
		getDeclaredField 可以获取本类所有的字段，包括private的，但是不能获取继承来的字段。
		(注： 这里只能获取到private的字段，但并不能访问该private字段的值,除非加上setAccessible(true))*/
		
//		private可读 ,不可写是肯定的，只有添加 f1.setAccessible(true);方法设置可写
	}

}
