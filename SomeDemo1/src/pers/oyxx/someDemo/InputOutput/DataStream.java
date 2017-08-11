package pers.oyxx.someDemo.InputOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*使用数据流的writeUTF()和readUTF() 可以进行数据的格式化顺序读写
如本例，通过DataOutputStream 向文件顺序写出 布尔值，整数和字符串。 然后再通过DataInputStream 顺序读入这些数据。

注： 要用DataInputStream 读取一个文件，这个文件必须是由DataOutputStream 写出的，否则会出现EOFException，因为DataOutputStream 在写出的时候会做一些特殊标记，只有DataInputStream 才能成功的读取。*/

//数据流，基于字节流
public class DataStream {

	public static void main(String[] args) {
		write();
		read();
	}
	
	//用数据流写入数据到文件中
	static void write(){
		File f=new File("h:/DataStreamTestFile.txt");
		try(FileOutputStream fos=new FileOutputStream(f);DataOutputStream dos=new DataOutputStream(fos);){
			dos.writeBoolean(false);
			dos.writeInt(666);
			dos.writeInt(233);
//			dos.writeBoolean(true);
			dos.writeUTF("What's your name?");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	//用数据流读取数据到程序中
	static void read(){
		File f=new File("h:/DataStreamTestFile.txt");
		try(FileInputStream fis=new FileInputStream(f);DataInputStream dis=new DataInputStream(fis);) {
			boolean b1=dis.readBoolean();
			int i1=dis.readInt();
			int i2=dis.readInt();
//			boolean b2=dis.readBoolean();
			String str=dis.readUTF();
			
			System.out.println("读取到布尔值1："+b1);
			System.out.println("读取到整数1："+i1);
			System.out.println("读取到整数2："+i2);
//			System.out.println("读取到布尔值2："+b2);
			System.out.println("读取到字符串："+str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

