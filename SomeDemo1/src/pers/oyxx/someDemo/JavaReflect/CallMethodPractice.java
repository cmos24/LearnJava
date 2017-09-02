package pers.oyxx.someDemo.JavaReflect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//反射调用方法练习
/*继续上一个练习 练习-通过配置文件获取对象，把hero.config改动成为支持如下格式：
 
charactor.APHero
gareen
charactor.ADHero
teemo

首先根据这个配置文件，使用反射实例化出两个英雄出来。
然后通过反射给这两个英雄设置名称，接着再通过反射，调用第一个英雄的attackHero方法，攻击第二个英雄*/
public class CallMethodPractice {
	
	public static void main(String[] args) {
		File configFile=new File("h:/hero1.config");
		if(!configFile.exists()){
			return;
		}
		
		
		try(FileReader fr=new FileReader(configFile);
			BufferedReader br=new BufferedReader(fr);
		){//获取配置文件内容
			char[] content=new char[(int)(configFile.length())];
			br.read(content);
			//用回车换行来分割字符串，分开获得文件中每一行的内容
			String[] fileContent=new String(content).split("\r\n");
			String hero1ClassName=fileContent[0];
			String hero1Name=fileContent[1];
			String hero2ClassName=fileContent[2];
			String hero2Name=fileContent[3];
			
			//通过反射实例化2个英雄对象
			Class h1=Class.forName(hero1ClassName);
			Constructor c1=h1.getConstructor();
			Hero3 hero1=(Hero3)c1.newInstance();
            
			
			Class h2=Class.forName(hero2ClassName);
			Constructor c2=h2.getConstructor();
			Hero3 hero2=(Hero3)c2.newInstance();
//			Object hero2=c2.newInstance();//这样写也可以
			
			//通过反射给这2个英雄设置名称
//			Field f1=hero1.class.getDeclaredField("name");//不能这样写因为hero1是一个实例化出来的对象，class属性应该用在类上
//			Field f1=hero1.getClass().getDeclaredField("name");//为什么这样写set之后hero1的name会变成null?
//			Field f1=Hero3.class.getDeclaredField("name");//这样写可以
//			Field f1=hero1.getClass().getSuperclass().getDeclaredField("name");//这样写也可以
			
			//Field f1=h1.getDeclaredField("name");
			/*如果像上一行这样写会报错
			 java.lang.NoSuchFieldException: name
				at java.lang.Class.getDeclaredField(Unknown Source)
				at pers.oyxx.someDemo.JavaReflect.CallMethodPractice.main(CallMethodPractice.java:60)			  
			 * */			

			Field f1=h1.getField("name");//这样写可以
			f1.setAccessible(true);//这个方法对于getField获得的字段有用吗？
			f1.set(hero1, hero1Name);
//			System.out.println(hero1.name);
			
			Field f2=Hero3.class.getDeclaredField("name");
			f2.setAccessible(true);
			f2.set(hero2, hero2Name);
//			System.out.println(hero2.name);
			
			/*总结：用getDeclaredField方法获得某字段再设置的话要用目标类的父类对象（或者字段所在的类对象，如在这里name字段是存在于Hero3中的）才会成功
			 * 而用getField获得字段的话可以直接用于目标类对象
			 * getField 只能获取public的，包括从父类继承来的字段。
			   getDeclaredField 可以获取本类所有的字段，包括private的，但是不能获取继承来的字段。 (注： 这里只能获取到private的字段，但并不能访问该private字段的值,除非加上setAccessible(true))
			 * */
			
			//通过反射，调用第一个英雄的attackHero方法，攻击第二个英雄
			Method attackHero=h1.getMethod("attackHero", Hero3.class);
			attackHero.invoke(hero1, hero2);
			
		}catch(IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		
	}

}
