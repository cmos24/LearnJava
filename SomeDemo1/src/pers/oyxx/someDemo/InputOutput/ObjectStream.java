package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*对象流指的是可以直接把一个对象以流的形式传输给其他的介质，比如硬盘 
一个对象以流的形式进行传输，叫做序列化。 该对象所对应的类，必须是实现Serializable接口*/


/*创建一个Hero对象，设置其名称为garen。 
把该对象序列化到一个文件garen.lol。
然后再通过序列化把该文件转换为一个Hero对象

注：把一个对象实例化有一个前提类，这个对象的类，必须实现了Serializable接口*/

//序列化一个对象,对象输入输出流基于字节流
public class ObjectStream {
	public static void main(String[] args){
		//创建一个Hero garen
        //要把Hero对象直接保存在文件上，务必让Hero类实现Serializable接口
		Hero h=new Hero();
		h.name="garen";
		h.hp=616;
		
		//准备一个文件用于保存该对象
		File f=new File("h:/garen.lol");
		
		try(
				//创建对象输出流
				FileOutputStream fos=new FileOutputStream(f);
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				//创建对象输入流
				FileInputStream fis=new FileInputStream(f);
				ObjectInputStream ois=new ObjectInputStream(fis);				
			)
		{
			oos.writeObject(h);
			Hero h2=(Hero)ois.readObject();
			System.out.println(h2.name);
			System.out.println(h2.hp);
		}catch(IOException e1){
			e1.printStackTrace();
		}catch(ClassNotFoundException e2){
			e2.printStackTrace();//对应Hero h2=(Hero)ois.readObject();
		}
	}
}
