package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*�����ļ��ǳ�����IO������������·�����ʵ�ָ���Դ�ļ�srcFile��Ŀ���ļ�destFile

public static void copyFile(String srcFile, String destFile){
}
*/
//�����ļ�
public class CopyFile {

	public static void main(String[] args) {
		copyFile("h:/f1.txt","h:f22.txt");
	}
	/**
	 * ����Դ�ļ���Ŀ���ļ�
	 * @param srcFile
	 * 	Դ�ļ�
	 * @param destFile
	 * 	Ŀ���ļ�
	 */
	public static void copyFile(String srcFile,String destFile){
		File srcFile1=new File(srcFile);
		File destFile1=new File(destFile);
		//���������ã���ΪԴ�ļ����ܴܺ�ȫ���ŵ��ַ������к������ڴ棬�û���һ��һ��д��ͻ�ȽϺã�Answer���еķ�����
		byte[] fileCotent=new byte[(int)srcFile1.length()];
		try(
				FileInputStream fis=new FileInputStream(srcFile1);
				FileOutputStream fos=new FileOutputStream(destFile1);
			)
		{
			fis.read(fileCotent);
			fos.write(fileCotent);
			System.out.println("�ļ����Ƴɹ�");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
