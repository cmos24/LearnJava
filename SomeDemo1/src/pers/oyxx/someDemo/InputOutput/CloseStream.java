package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*���е����������������������������ʹ�����֮�󣬶�Ӧ�ùرա� ������رգ����������Դռ�õ��˷ѡ� 
�����Ƚϴ��ʱ�򣬻�Ӱ�쵽ҵ���������չ��*/

//�ر����ķ���
public class CloseStream {
	public static void main(String[] args){
		/*����1 : ��try�йر�
		��try����������ر��ļ�����������ǰ���ʾ���ж���ʹ�����ַ�ʽ����������һ���׶ˣ�
		����ļ������ڣ����߶�ȡ��ʱ�����������׳��쳣����ô�Ͳ���ִ����һ�йر����Ĵ��룬���ھ޴����Դռ�������� ���Ƽ�ʹ��*/
		try {
			File f1=new File("h:/TestFile.txt");
			FileInputStream fis1=new FileInputStream(f1);
			byte[] all=new byte[(int)f1.length()];
			fis1.read(all);
			for(byte b:all){
				System.out.println("f1�����ݣ�"+b);
			}
		} catch (IOException e) {
			e.printStackTrace();			  
		}
		
		//����2����finally�йر���
		
		/*		���Ǳ�׼�Ĺر����ķ�ʽ
		1. ���Ȱ���������������try�����棬���������try���棬���������޷��ִ�finally.
		2. ��finally�ر�֮ǰ��Ҫ���жϸ������Ƿ�Ϊ��
		3. �رյ�ʱ����Ҫ��һ�ν���try catch����

		���Ǳ�׼���Ͻ��Ĺر����ķ�ʽ�����ǿ���ȥ�ܷ���������д����Ҫ�Ļ��߲��Դ����ʱ�򣬶�����������������try�ķ�ʽ����Ϊ���鷳~*/
		
		File f2=new File("h:/TestFile.txt");
		FileInputStream fis2=null;
		try {
			fis2=new FileInputStream(f2);
			byte[] all=new byte[(int)f2.length()];
			fis2.read(all);
			for(byte b:all){
				System.out.println("f2�����ݣ�"+b);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		finally {
			if(null==fis2){
				try {
					fis2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		//����3��ʹ��try()�ķ�ʽ
		/*
		 * ����������try()��,try,catch����finally������ʱ�򣬻��Զ��ر� ���ֱ�д����ķ�ʽ����
		 * try-with-resources�� ���Ǵ�JDK7��ʼ֧�ֵļ���
		 * 
		 * ���е�������ʵ����һ���ӿڽ��� AutoCloseable���κ���ʵ��������ӿڣ���������try()�н���ʵ������ ������try,
		 * catch, finally������ʱ���Զ��رգ����������Դ��
		 */
		File f3=new File("h:/TestFile.txt");
		//����������try()��,try,catch����finally������ʱ�򣬻��Զ��ر�
		try(FileInputStream fis3=new FileInputStream(f3)){
			byte[] all=new byte[(int)f3.length()];
			fis3.read(all);
			for(byte b:all){
				System.out.println("f3�����ݣ�"+b);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
}
