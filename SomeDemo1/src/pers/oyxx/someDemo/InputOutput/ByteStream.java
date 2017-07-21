package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*InputStream是字节输入流，同时也是抽象类，只提供方法声明，不提供方法的具体实现。
FileInputStream 是InputStream子类，以FileInputStream 为例进行文件读取

OutpuStream是字节输出流，同时也是抽象类，只提供方法声明，不提供方法的具体实现。
FileOutputStream 是OutputStream子类，以FileOutputStream 为例向文件写出数据*/

public class ByteStream {
	public static void main(String[] args) {
		// 以字节流的形式读取文件内容
		try {
			// 文件对象指向的文件内容是AB两个大写字母，对应ASCII码为65、66
			File f1 = new File("h:/TestFile3.txt");
			// 创建基于文件的输入流
			FileInputStream fis = new FileInputStream(f1);
			// 创建字节数组，其长度是文件的长度
			byte[] all = new byte[(int) f1.length()];
			// 以字节流的形式读取文件所有内容，传到字节数组里
			fis.read(all);
			for (byte b : all) {
				// 打印出来是文件内容的ASCII码，65、66
				System.out.println(b);
			}
			// 每次使用完流都应该进行关闭
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 以字节流的形式写入文件内容
		try {
			/*
			 * 注: 如果文h:/TestFile4.txt不存在，写出操作会自动创建该文件。 但是如果是文件
			 * h:/abc/TestFile4.txt，而目录abc又不存在，会抛出异常
			 */

			// 准备文件TestFile4.txt,内容是空的
			File f2 = new File("h:/test/est/TestFile4.txt");
			//因为默认情况下，文件系统中不存在 d:\xyz\abc\def，所以输出会失败
			
			// 先获取文件所在的目录
			File dir = f2.getParentFile();
			if (!dir.exists()) {// 如果目录不存在
				// dir.mkdir(); //使用mkdir会抛出异常，因为该目录的父目录也不存在
				dir.mkdirs(); // 使用mkdirs则会把不存在的目录都创建好
			}
			// 创建基于文件的输出流
			FileOutputStream fos = new FileOutputStream(f2);
			// 用XY初始化字节数组(ASCII码分别对应88、89)
			byte[] data = new byte[] { 88, 89 };
			// 把数据写入到输出流
			fos.write(data);
			// 关闭输出流
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// 主函数尾部
}
