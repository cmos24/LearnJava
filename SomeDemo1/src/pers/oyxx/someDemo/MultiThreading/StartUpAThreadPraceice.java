package pers.oyxx.someDemo.MultiThreading;

import java.io.File;

/*�� ��ϰ-�����ļ����� ��Ϊ���̲߳����ļ�����
ԭ��ϰ��˼·�Ǳ��������ļ������������ļ�ʱ.java��ʱ�򣬲�������ļ������ݣ��������֮���ٱ�����һ���ļ�

����ͨ�����̵߳������˼·��
���������ļ������������ļ���.java��ʱ�򣬴���һ���߳�ȥ��������ļ������ݣ����صȴ�����߳̽���������������һ���ļ�*/
// ���� 6 : ��ϰ-ͬ�������ļ�����
public class StartUpAThreadPraceice {
	
	public static void searchInJava(File file,String searchStr){
		if(file.isFile()){//������ļ�
			if(file.getName().toLowerCase().endsWith("java")){//�����java�ļ�
				SearchFileThread sft=new SearchFileThread(file, searchStr);
				sft.start();
			}
		}
		if(file.isDirectory()){//�����Ŀ¼
			File[] fs=file.listFiles();
			for(File eachFile:fs){
				searchInJava(eachFile,searchStr);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("������ʼ");
		searchInJava(new File("h:/TestThread"),"thisisaflag");
	}

}
