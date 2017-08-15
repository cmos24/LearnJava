package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//�����������Ϣ�Զ��������ļ�
public class AutoCreateClassFile {
	public static void main(String[] args) {
		// �����û�����
		Scanner s = new Scanner(System.in);
		System.out.println("�������������");
		String className = s.nextLine();
		System.out.println("���������Ե�����");
		String type = s.nextLine();
		System.out.println("���������Ե�����");
		String property = s.nextLine();
		String Uproperty = toUpperFirstLetter(property);

		// ��ȡģ���ļ�
		File modelFile = new File("h:/Model.txt");
		String modelContent = null;
		try (FileReader fr = new FileReader(modelFile)) {
			char[] cs=new char[(int)modelFile.length()];
			fr.read(cs);
			modelContent=new String(cs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//�滻
		String fileContent=modelContent.replaceAll("@class@", className);
		fileContent=fileContent.replaceAll("@type@", type);
		fileContent=fileContent.replace("@property@", property);
		fileContent=fileContent.replaceAll("@Uproperty@", Uproperty);
		String fileName=className+".java";
		//�滻�������
		System.out.println("�滻������ݣ�");
		System.out.println(fileContent);//��������ᱣ���ı��ļ��еĸ�ʽ���������ʲô��
		File file=new File("h:/",fileName);
		
		try (	//�����ַ���������ڽ��滻����������ַ�����ʽд���ļ�
				FileWriter fw=new FileWriter(file);
			)
		{
			fw.write(fileContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("�ļ������ڣ�"+file.getAbsolutePath());
		
		
	}// main����β��

	/**
	 * ���ַ�������ĸת���ɴ�д
	 * 
	 * @param str
	 *            ����ĸҪת���ɴ�д���ַ���
	 * @return
	 */
	public static String toUpperFirstLetter(String str) {
		char upperCaseFirst = Character.toUpperCase(str.charAt(0));// ����ĸ��д��
		String rest = str.substring(1);// ȡҪ������ַ�������ĸ����Ĳ���
		return upperCaseFirst + rest;
	}
}
