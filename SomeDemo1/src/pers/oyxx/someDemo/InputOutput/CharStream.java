package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//�ַ���
public class CharStream {
	public static void main(String[] args) {
		// ʹ���ַ�����ȡ�ļ�
		File f1 = new File("h:/TestFile.txt");
		// ׼�������ļ���Reader
		try (FileReader fr = new FileReader(f1)) {
			char[] all = new char[(int) f1.length()];
			fr.read(all);
			for (char c : all) {
				System.out.println(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//ʹ���ַ������ַ���д�뵽�ļ�
		File f2=new File("h:/TestFile3.txt");
		// ���������ļ���Writer
		try(FileWriter fw=new FileWriter(f2)) {
			String data="abcd12345678";
			char[] cs=data.toCharArray();
			fw.write(cs);
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		

	}
}
