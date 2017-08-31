package pers.oyxx.someDemo.JavaReflect;

import java.lang.reflect.Constructor;

//创建对象
public class CreateObject {
	/*与传统的通过new 来获取对象的方式不同 
	反射机制，会先拿到Product的“类对象”,然后通过类对象获取“构造器对象” 
	再通过构造器对象创建一个对象*/
	public static void main(String[] args){
		// 步骤 1 : 创建一个对象
		/*通过反射机制创建一个对象*/
		
		//传统使用new方式创建对象
		Hero h1=new Hero();
		h1.name="teemo";
		System.out.println(h1);
		
		try{
			//使用反射的方式创建对象
			String className="pers.oyxx.someDemo.JavaReflect.Hero";
			//类对象
			Class pClass=Class.forName(className);
			//构造器
			Constructor c=pClass.getConstructor();
			//通过构造器实例化
			Hero h2=(Hero)c.newInstance();
			h2.name="gareen";
			System.out.println(h2);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
