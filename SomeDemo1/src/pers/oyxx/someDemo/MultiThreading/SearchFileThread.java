package pers.oyxx.someDemo.MultiThreading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//查找文件内容的线程
public class SearchFileThread extends Thread{
	private File file;
	private String searchStr;
	
	public SearchFileThread(File file,String searchStr){
		this.file=file;
		this.searchStr=searchStr;
	}
	
	public void run(){
		String fileContent=readFileConent(file);//以字符形式读取文件内容
		if(fileContent.contains(searchStr)){
			System.out.printf("找到目标字符串%s，在文件%s中%n",searchStr,file);
		}
		//这里不用分文件或者文件夹的情况，因为判断是否为目录是遍历的工作，这个线程只针对非目录文件进行搜索工作
	}
	
	//以字符形式读取文件内容
	public String readFileConent(File file){
        try (FileReader fr = new FileReader(file);BufferedReader br=new BufferedReader(fr);) {
            char[] all = new char[(int) file.length()];
            br.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } 
    }

	
}
