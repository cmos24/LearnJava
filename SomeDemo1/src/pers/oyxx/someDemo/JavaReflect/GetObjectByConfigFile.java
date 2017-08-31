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
			System.out.println("�����ļ�������");
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
		//h.name="����";
		System.out.println(h);
		h.Attack();
		/*ͨ����ӡh�����Է��֣��������ļ�������ݷ����仯��ʱ�򣬾ͻ�õ���ͬ�Ķ��� 

		Դ���벻��Ҫ�����κα仯��ֻ��Ҫ�޸������ļ����Ϳ��Ե��³�����߼������仯�� ����һ�ֻ������õı��˼�롣

		Spring����е�IOC��DI�ĵײ���ǻ��������Ļ���ʵ���ˡ�*/
	}

}
