package pers.oyxx.someDemo.MultiThreading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//�����ļ����ݵ��߳�
public class SearchFileThread extends Thread{
	private File file;
	private String searchStr;
	
	public SearchFileThread(File file,String searchStr){
		this.file=file;
		this.searchStr=searchStr;
	}
	
	public void run(){
		String fileContent=readFileConent(file);//���ַ���ʽ��ȡ�ļ�����
		if(fileContent.contains(searchStr)){
			System.out.printf("�ҵ�Ŀ���ַ���%s�����ļ�%s��%n",searchStr,file);
		}
		//���ﲻ�÷��ļ������ļ��е��������Ϊ�ж��Ƿ�ΪĿ¼�Ǳ����Ĺ���������߳�ֻ��Է�Ŀ¼�ļ�������������
	}
	
	//���ַ���ʽ��ȡ�ļ�����
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
