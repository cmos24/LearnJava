package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//字符流
public class CharStream {
	public static void main(String[] args) {
		// 使用字符流读取文件
		File f1 = new File("h:/TestFile.txt");
		// 准备基于文件的Reader
		try (FileReader fr = new FileReader(f1)) {
			char[] all = new char[(int) f1.length()];
			fr.read(all);
			for (char c : all) {
				System.out.println(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//使用字符流把字符串写入到文件
		File f2=new File("h:/TestFile3.txt");
		// 创建基于文件的Writer
		try(FileWriter fw=new FileWriter(f2)) {
			String data="abcd12345678";
			char[] cs=data.toCharArray();
			fw.write(cs);
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		

	}
}
