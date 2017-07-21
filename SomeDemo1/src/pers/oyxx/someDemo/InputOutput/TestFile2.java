package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//文件常用方法1
public class TestFile2 {

	public static void main(String[] args) {
		File f = new File("h:/TestFile.txt");
		System.out.println("当前对象指向的文件是：" + f + " 文件是否存在：" + f.exists());
		System.out.println("判断是否是文件夹：" + f.isDirectory() + " 是否是文件：" + f.isFile());
		System.out.println("文件长度" + f.length());// 看文件里面有多少个字节，TextFile.txt里面写了“测试文件”四个字，所以有8个字节，文件长度为8
		// 文件最后修改时间
		long time = f.lastModified();
		Date d = new Date(time);
		System.out.println("获取文件最后修改的时间：" + d);
		// 设置文件修改时间为2017-1-1 11:11:11
		String newLastTime = "2017-1-1 11:11:11";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			d = sdf.parse(newLastTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		f.setLastModified(d.getTime());
		System.out.println("获取修改后的文件最后修改的时间：" + d);

		// 重命名文件，传入的是一个有着新名字的新文件对象
		File f2 = new File("h:/TestFile.txt");
		f.renameTo(f2);
		/*注意1： 需要在D:\LOLFolder确实存在一个LOL.exe,才可以看到对应的文件长度、修改时间等信息
		注意2： renameTo方法用于对物理文件名称进行修改，但是并不会修改File对象的name属性。*/
	}

}
