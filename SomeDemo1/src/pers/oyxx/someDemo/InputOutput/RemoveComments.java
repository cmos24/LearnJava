package pers.oyxx.someDemo.InputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*设计一个方法，用于移除Java文件中的注释

public void removeComments(File javaFile)
 
比如，移出以//开头的注释行
 
File f = new File("d:/LOLFolder/LOL.exe");
System.out.println("当前文件是：" +f);
//文件是否存在
System.out.println("判断是否存在："+f.exists());
//是否是文件夹
System.out.println("判断是否是文件夹："+f.isDirectory());
 
 
注： 如果注释在后面，或者是风格的注释，暂不用处理*/
public class RemoveComments {

	public static void main(String[] args) {
		RemoveComments.removeComment(new File("h:/TestJavaFile.java"));
	}
	
	//清除Java文件中的注释
	/**
	 *  @param javaFile
	 *  	要清除注释的java文件
	 */
	public static void removeComment(File javaFile){
		File f=javaFile;
		try(
				//创建文件字符输入流
				FileReader fr=new FileReader(f);
				//基于字符流创建写入写出缓存流
				BufferedReader br=new BufferedReader(fr);
				//创建文件字符输出流
				FileWriter fw=new FileWriter(new File("h:/output.java"));
				PrintWriter pw=new PrintWriter(fw);
			)
		{
			while(true){
				String line=br.readLine();
				if(null==line){
					System.out.println("处理结束");
					break;
				}else{
					System.out.println(line);
					if("//".equals(line.substring(0, 2))){//这里不能用"=="来判断，以为是两个字符串相当于对比两个对象的内存地址，要对比字符串内容的话用equal()方法
						pw.println(line.substring(2));
					}else{
						pw.println(line);
					}
				}
			}			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	
}
