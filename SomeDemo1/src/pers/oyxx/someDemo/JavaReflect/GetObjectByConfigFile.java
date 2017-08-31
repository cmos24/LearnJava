package pers.oyxx.someDemo.JavaReflect;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class GetObjectByConfigFile {

	public static Hero getHero(){
		Hero rh=null;
		File heroConfigFile=new File("H:/hero.config");
		if(!heroConfigFile.exists()){
			System.out.println("配置文件不存在");
			return null;
		}else{
			try(FileReader fr=new FileReader(heroConfigFile);
			) {				
				char[] hero=new char[(int) heroConfigFile.length()];
				fr.read(hero);
				String heroCalss=new String(hero);
				
				Class h=Class.forName(heroCalss);
				rh=(Hero)(h.getConstructor().newInstance());
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}			
		}
		
		return rh;
	}
	
	public static void main(String[] args) {
		
		Hero h = getHero();
		//h.name="寒冰";
		System.out.println(h);
		h.Attack();
		/*通过打印h，可以发现，当配置文件里的内容发生变化的时候，就会得到不同的对象。 

		源代码不需要发生任何变化，只需要修改配置文件，就可以导致程序的逻辑发生变化， 这是一种基于配置的编程思想。

		Spring框架中的IOC和DI的底层就是基于这样的机制实现了。*/
	}

}
