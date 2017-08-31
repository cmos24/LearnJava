package pers.oyxx.someDemo.JavaReflect;

//获取类对象
public class ClassObject {
	/*步骤 1 : 什么是类对象
	在理解类对象之前，先说我们熟悉的对象之间的区别：
	gareen和teemo都是Hero对象，他们的区别在于，各自有不同的名称，血量，伤害值。
	
	然后说说类之间的区别
	Hero和Item都是类，他们的区别在于有不同的方法，不同的属性。
	
	类对象，就是用于描述这种类，都有什么属性，什么方法的*/
	
	/*步骤 2 : 获取类对象 
	获取类对象有3种方式
	1. Class.forName
	2. Hero.class
	3. new Hero().getClass()
	
	在一个JVM中，一种类，只会有一个类对象存在。所以以上三种方式取出来的类对象，都是一样的。
	
	注： 准确的讲是一个ClassLoader下，一种类，只会有一个类对象存在。通常一个JVM下，只会有一个ClassLoader。
	因为还没有引入ClassLoader概念， 所以暂时不展开了。*/
	
	public static void main(String[] args) {
		String className="pers.oyxx.someDemo.JavaReflect.Hero";
		try{
			
			Class class1=Class.forName(className);
			Class class2=Hero.class;
			Class class3=new Hero().getClass();
//			无论什么途径获取类对象，都会导致静态属性被初始化，而且只会执行一次。
			System.out.println("3种方法获得的name是否相同：");
			System.out.println(class1==class2);
			System.out.println(class2==class3);
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
}
