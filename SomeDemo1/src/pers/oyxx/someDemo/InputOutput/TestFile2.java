package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//�ļ����÷���1
public class TestFile2 {

	public static void main(String[] args) {
		File f = new File("h:/TestFile.txt");
		System.out.println("��ǰ����ָ����ļ��ǣ�" + f + " �ļ��Ƿ���ڣ�" + f.exists());
		System.out.println("�ж��Ƿ����ļ��У�" + f.isDirectory() + " �Ƿ����ļ���" + f.isFile());
		System.out.println("�ļ�����" + f.length());// ���ļ������ж��ٸ��ֽڣ�TextFile.txt����д�ˡ������ļ����ĸ��֣�������8���ֽڣ��ļ�����Ϊ8
		// �ļ�����޸�ʱ��
		long time = f.lastModified();
		Date d = new Date(time);
		System.out.println("��ȡ�ļ�����޸ĵ�ʱ�䣺" + d);
		// �����ļ��޸�ʱ��Ϊ2017-1-1 11:11:11
		String newLastTime = "2017-1-1 11:11:11";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			d = sdf.parse(newLastTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		f.setLastModified(d.getTime());
		System.out.println("��ȡ�޸ĺ���ļ�����޸ĵ�ʱ�䣺" + d);

		// �������ļ����������һ�����������ֵ����ļ�����
		File f2 = new File("h:/TestFile.txt");
		f.renameTo(f2);
		/*ע��1�� ��Ҫ��D:\LOLFolderȷʵ����һ��LOL.exe,�ſ��Կ�����Ӧ���ļ����ȡ��޸�ʱ�����Ϣ
		ע��2�� renameTo�������ڶ������ļ����ƽ����޸ģ����ǲ������޸�File�����name���ԡ�*/
	}

}
