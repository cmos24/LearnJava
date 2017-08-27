package pers.oyxx.someDemo.MultiThreading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchFileTask implements Runnable{
	private File file;
	private String search;
	
	//将文件和要搜索的字符串通过构造函数传进任务里面
	public SearchFileTask(File file,String search) {
		this.file=file;
		this.search=search;
	}
	
	@Override
	public void run() {
		if(getFileContent().contains(search)){
			System.out.printf("%s找到了目标字符串%s,在文件：%s%n",Thread.currentThread(),search,file.getAbsolutePath());
		}
	}
	
	//获得文件内容
	private String getFileContent(){
		String fileContent = null;
		char[] all=new char[(int) file.length()];
		try(FileReader fr=new FileReader(file);BufferedReader br=new BufferedReader(fr);) {
			br.read(all);
			fileContent=new String(all);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileContent;
	}
	
}
