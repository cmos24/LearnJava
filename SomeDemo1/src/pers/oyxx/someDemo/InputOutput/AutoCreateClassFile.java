package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//根据输入的信息自动创建类文件
public class AutoCreateClassFile {
	public static void main(String[] args) {
		// 接受用户输入
		Scanner s = new Scanner(System.in);
		System.out.println("请输入类的名称");
		String className = s.nextLine();
		System.out.println("请输入属性的类型");
		String type = s.nextLine();
		System.out.println("请输入属性的名称");
		String property = s.nextLine();
		String Uproperty = toUpperFirstLetter(property);

		// 读取模板文件
		File modelFile = new File("h:/Model.txt");
		String modelContent = null;
		try (FileReader fr = new FileReader(modelFile)) {
			char[] cs=new char[(int)modelFile.length()];
			fr.read(cs);
			modelContent=new String(cs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//替换
		String fileContent=modelContent.replaceAll("@class@", className);
		fileContent=fileContent.replaceAll("@type@", type);
		fileContent=fileContent.replace("@property@", property);
		fileContent=fileContent.replaceAll("@Uproperty@", Uproperty);
		String fileName=className+".java";
		//替换后的内容
		System.out.println("替换后的内容：");
		System.out.println(fileContent);//这样输出会保留文本文件中的格式，比如分行什么的
		File file=new File("h:/",fileName);
		
		try (	//创建字符输出流用于将替换后的内容以字符的形式写入文件
				FileWriter fw=new FileWriter(file);
			)
		{
			fw.write(fileContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("文件保存在："+file.getAbsolutePath());
		
		
	}// main函数尾部

	/**
	 * 将字符串首字母转换成大写
	 * 
	 * @param str
	 *            首字母要转换成大写的字符串
	 * @return
	 */
	public static String toUpperFirstLetter(String str) {
		char upperCaseFirst = Character.toUpperCase(str.charAt(0));// 首字母大写化
		String rest = str.substring(1);// 取要处理的字符串首字母以外的部分
		return upperCaseFirst + rest;
	}
}
