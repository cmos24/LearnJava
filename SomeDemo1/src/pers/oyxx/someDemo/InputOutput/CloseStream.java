package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*���е����������������������������ʹ�����֮�󣬶�Ӧ�ùرա� ������رգ����������Դռ�õ��˷ѡ� 
�����Ƚϴ��ʱ�򣬻�Ӱ�쵽ҵ���������չ��*/

public class CloseStream {
	public static void main(String[] args){
		/*����1 : ��try�йر�
		��try����������ر��ļ�����������ǰ���ʾ���ж���ʹ�����ַ�ʽ����������һ���׶ˣ�
		����ļ������ڣ����߶�ȡ��ʱ�����������׳��쳣����ô�Ͳ���ִ����һ�йر����Ĵ��룬���ھ޴����Դռ�������� ���Ƽ�ʹ��*/
		try {
			File f=new File("h:/TestFile.txt");
			FileInputStream fis=new FileInputStream(f);
			byte[] all=new byte[(int)f.length()];
			fis.read(all);
			for(byte b:all){
				System.out.println(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
			  
		}
	}
}
