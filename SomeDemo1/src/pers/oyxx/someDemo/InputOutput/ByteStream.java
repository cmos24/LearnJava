package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*InputStream���ֽ���������ͬʱҲ�ǳ����ֻ࣬�ṩ�������������ṩ�����ľ���ʵ�֡�
FileInputStream ��InputStream���࣬��FileInputStream Ϊ�������ļ���ȡ

OutpuStream���ֽ��������ͬʱҲ�ǳ����ֻ࣬�ṩ�������������ṩ�����ľ���ʵ�֡�
FileOutputStream ��OutputStream���࣬��FileOutputStream Ϊ�����ļ�д������*/

public class ByteStream {
	public static void main(String[] args) {
		// ���ֽ�������ʽ��ȡ�ļ�����
		try {
			// �ļ�����ָ����ļ�������AB������д��ĸ����ӦASCII��Ϊ65��66
			File f1 = new File("h:/TestFile3.txt");
			// ���������ļ���������
			FileInputStream fis = new FileInputStream(f1);
			// �����ֽ����飬�䳤�����ļ��ĳ���
			byte[] all = new byte[(int) f1.length()];
			// ���ֽ�������ʽ��ȡ�ļ��������ݣ������ֽ�������
			fis.read(all);
			for (byte b : all) {
				// ��ӡ�������ļ����ݵ�ASCII�룬65��66
				System.out.println(b);
			}
			// ÿ��ʹ��������Ӧ�ý��йر�
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// ���ֽ�������ʽд���ļ�����
		try {
			/*
			 * ע: �����h:/TestFile4.txt�����ڣ�д���������Զ��������ļ��� ����������ļ�
			 * h:/abc/TestFile4.txt����Ŀ¼abc�ֲ����ڣ����׳��쳣
			 */

			// ׼���ļ�TestFile4.txt,�����ǿյ�
			File f2 = new File("h:/test/est/TestFile4.txt");
			//��ΪĬ������£��ļ�ϵͳ�в����� d:\xyz\abc\def�����������ʧ��
			
			// �Ȼ�ȡ�ļ����ڵ�Ŀ¼
			File dir = f2.getParentFile();
			if (!dir.exists()) {// ���Ŀ¼������
				// dir.mkdir(); //ʹ��mkdir���׳��쳣����Ϊ��Ŀ¼�ĸ�Ŀ¼Ҳ������
				dir.mkdirs(); // ʹ��mkdirs���Ѳ����ڵ�Ŀ¼��������
			}
			// ���������ļ��������
			FileOutputStream fos = new FileOutputStream(f2);
			// ��XY��ʼ���ֽ�����(ASCII��ֱ��Ӧ88��89)
			byte[] data = new byte[] { 88, 89 };
			// ������д�뵽�����
			fos.write(data);
			// �ر������
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// ������β��
}
