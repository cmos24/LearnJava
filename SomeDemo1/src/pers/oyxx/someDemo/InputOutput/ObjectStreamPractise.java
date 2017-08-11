package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*练习-序列化数组
 准备一个长度是10，类型是Hero的数组，使用10个Hero对象初始化该数组
然后把该数组序列化到一个文件heros.lol
接着使用ObjectInputStream 读取该文件，并转换为Hero数组，验证该数组中的内容，是否和序列化之前一样*/

//序列化数组
public class ObjectStreamPractise {
	public static void main(String[] args) {
		File f=new File("h:/heros.lol");
		Hero[] hs=new Hero[10];
		for(int i=0;i<10;i++){
			hs[i]=new Hero("hero:"+i);
		}
		try(
				//创建对象输出流，基于字节输出流
				FileOutputStream fos=new FileOutputStream(f);
				ObjectOutputStream oos= new ObjectOutputStream(fos);
				//创建对象输入流，基于字节输入流
				FileInputStream fis=new FileInputStream(f);
				ObjectInputStream ois=new ObjectInputStream(fis);				
			)
		{
			oos.writeObject(hs);
			Hero[] hs2=(Hero[])ois.readObject();
			System.out.println("查看中文件中反序列化出来的数组中的每一个元素：");
			for(Hero hero:hs2){
				System.out.println(hero.name);
			}
		}catch(IOException e1){
			e1.printStackTrace();
		}catch(ClassNotFoundException e2){
			e2.printStackTrace();
		}
	}
}
