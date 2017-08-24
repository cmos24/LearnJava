package pers.oyxx.someDemo.MultiThreading;

import java.io.File;

/*把 练习-查找文件内容 改为多线程查找文件内容
原练习的思路是遍历所有文件，当遍历到文件时.java的时候，查找这个文件的内容，查找完毕之后，再遍历下一个文件

现在通过多线程调整这个思路：
遍历所有文件，当遍历到文件是.java的时候，创建一个线程去查找这个文件的内容，不必等待这个线程结束，继续遍历下一个文件*/
// 步骤 6 : 练习-同步查找文件内容
public class StartUpAThreadPraceice {
	
	public static void searchInJava(File file,String searchStr){
		if(file.isFile()){//如果是文件
			if(file.getName().toLowerCase().endsWith("java")){//如果是java文件
				SearchFileThread sft=new SearchFileThread(file, searchStr);
				sft.start();
			}
		}
		if(file.isDirectory()){//如果是目录
			File[] fs=file.listFiles();
			for(File eachFile:fs){
				searchInJava(eachFile,searchStr);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("搜索开始");
		searchInJava(new File("h:/TestThread"),"thisisaflag");
	}

}
