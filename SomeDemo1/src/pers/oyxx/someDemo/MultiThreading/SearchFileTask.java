package pers.oyxx.someDemo.MultiThreading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchFileTask implements Runnable{
	private File file;
	private String search;
	
	//���ļ���Ҫ�������ַ���ͨ�����캯��������������
	public SearchFileTask(File file,String search) {
		this.file=file;
		this.search=search;
	}
	
	@Override
	public void run() {
		if(getFileContent().contains(search)){
			System.out.printf("%s�ҵ���Ŀ���ַ���%s,���ļ���%s%n",Thread.currentThread(),search,file.getAbsolutePath());
		}
	}
	
	//����ļ�����
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
