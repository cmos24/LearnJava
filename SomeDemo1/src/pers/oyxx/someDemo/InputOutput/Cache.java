package pers.oyxx.someDemo.InputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*�Խ�����Ӳ��Ϊ�����ֽ������ַ����ı׶ˣ� 
��ÿһ�ζ�д��ʱ�򣬶������Ӳ�̡� �����д��Ƶ�ʱȽϸߵ�ʱ�������ܱ��ֲ��ѡ� 
Ϊ�˽�����ϱ׶ˣ����û������� 
�������ڶ�ȡ��ʱ�򣬻�һ���Զ��϶�����ݵ������У��Ժ�ÿһ�εĶ�ȡ�������ڻ����з��ʣ�ֱ�������е����ݶ�ȡ��ϣ��ٵ�Ӳ��������ȡ�� 
�ͺñȳԷ������û������ÿ��һ�ڶ�������ȥ�����û�������Ȱѷ�ʢ���������ĳ����ˣ��ٵ�����ȥ�� 
��������д�����ݵ�ʱ�򣬻��Ȱ�����д�뵽��������ֱ���������ﵽһ���������Ű���Щ���ݣ�һ��д�뵽Ӳ����ȥ���������ֲ���ģʽ���Ͳ������ֽ������ַ�������ÿдһ���ֽڶ�����Ӳ�̣��Ӷ�������IO����*/

//������
public class Cache {
	public static void main(String[] args) {
		// ʾ�� 1 : ʹ�û�������ȡ����
		File f1 = new File("h:/TestFile4.txt");
		// �����ļ��ַ���
		// ���������뽨����һ�����ڵ����Ļ�����
		try (
				//�����ļ��ַ���
				FileReader fr = new FileReader(f1); 
				//���������뽨����һ�����ڵ����Ļ�����
				BufferedReader br = new BufferedReader(fr);
			) 
		{
			while (true) {
				// һ�ζ�һ��
				String line = br.readLine();
				if (null == line)
					break;
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ʾ�� 2 : ʹ�û�����д������
		// ���ļ�"h:/TestFile.txt"��д���������
		File f2 = new File("h:/TestFile.txt");
		try (
				//�����ļ��ַ���
				FileWriter fw = new FileWriter(f2); 
				//���������뽨�����Ѵ��ڵ����Ļ�����
				PrintWriter pw = new PrintWriter(fw);
			) 
		{
			pw.println("��һ��");
			pw.println("�ڶ���");
			pw.println("������");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ʾ�� 3 : flush
		// �е�ʱ����Ҫ����������д�뵽Ӳ�̣������ǵȻ������˲�д��ȥ�� ��ʱ�����Ҫ�õ�flush
		File f3 = new File("h:/TestFile.txt");
		try (
				//�����ļ��ַ���
				FileWriter fw = new FileWriter(f3);
				//���������뽨�����Ѿ����ڵ����Ļ�����
				PrintWriter pw = new PrintWriter(fw);
			) 
		{
			pw.println("���ǵ�һ��");
			//ǿ�ưѻ����е�����д��Ӳ�̣����ۻ����Ƿ�����
			pw.flush();
			pw.println("���ǵڶ���");
			pw.flush();
			pw.println("���ǵ�����");
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
