package pers.oyxx.someDemo.InputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*���һ�������������Ƴ�Java�ļ��е�ע��

public void removeComments(File javaFile)
 
���磬�Ƴ���//��ͷ��ע����
 
File f = new File("d:/LOLFolder/LOL.exe");
System.out.println("��ǰ�ļ��ǣ�" +f);
//�ļ��Ƿ����
System.out.println("�ж��Ƿ���ڣ�"+f.exists());
//�Ƿ����ļ���
System.out.println("�ж��Ƿ����ļ��У�"+f.isDirectory());
 
 
ע�� ���ע���ں��棬�����Ƿ���ע�ͣ��ݲ��ô���*/
public class RemoveComments {

	public static void main(String[] args) {
		RemoveComments.removeComment(new File("h:/TestJavaFile.java"));
	}
	
	//���Java�ļ��е�ע��
	/**
	 *  @param javaFile
	 *  	Ҫ���ע�͵�java�ļ�
	 */
	public static void removeComment(File javaFile){
		File f=javaFile;
		try(
				//�����ļ��ַ�������
				FileReader fr=new FileReader(f);
				//�����ַ�������д��д��������
				BufferedReader br=new BufferedReader(fr);
				//�����ļ��ַ������
				FileWriter fw=new FileWriter(new File("h:/output.java"));
				PrintWriter pw=new PrintWriter(fw);
			)
		{
			while(true){
				String line=br.readLine();
				if(null==line){
					System.out.println("�������");
					break;
				}else{
					System.out.println(line);
					if("//".equals(line.substring(0, 2))){//���ﲻ����"=="���жϣ���Ϊ�������ַ����൱�ڶԱ�����������ڴ��ַ��Ҫ�Ա��ַ������ݵĻ���equal()����
						pw.println(line.substring(2));
					}else{
						pw.println(line);
					}
				}
			}			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	
}
