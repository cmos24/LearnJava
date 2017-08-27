package pers.oyxx.someDemo.MultiThreading;

import java.io.File;

//��ϰ- �����̳߳�ͬ�������ļ�����
public class ThreadsPoolPractice {

	public static MyThreadsPool pool = new MyThreadsPool();

	public static void search(File file, String search) {
		if (file.isDirectory()) {
			File[] fs=file.listFiles();
			for(File each:fs){
				search(each, search);
			}

		}
		if (file.isFile()) {
			boolean isJavaFile = (file.getName().toLowerCase()).endsWith(".java");
			if (isJavaFile) {
				pool.add(new SearchFileTask(file, search));
			}
		}

	}

	public static void main(String[] args) {
		search(new File("h:/TestThread"), "thisisaflag");
	}

}
