package pers.oyxx.someDemo.InputOutput;

import java.io.File;

//�ļ����÷���2
public class TestFile3 {

	public static void main(String[] args) throws Exception {
		File f = new File("h:/TestFile3.txt");
		// ���ַ����������ʽ�����ص�ǰ�ļ����µ������ļ������������ļ������ļ��У���f�������ļ���
/*		String[] str = f.list();
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
*/		// ���ļ��������ʽ�����ص�ǰ�ļ����µ������ļ������������ļ������ļ��У�
		File[] fs = f.listFiles();
		// ���ַ�����ʽ���ػ�ȡ�����ļ���
		f.getParent();

		// ���ļ���ʽ���ػ�ȡ�����ļ���
		f.getParentFile();
		// �����ļ��У������skin�ļ��в����ڣ���������Ч
		f.mkdir();

		// �����ļ��У������skin�ļ��в����ڣ��ͻᴴ�����ļ���
		f.mkdirs();

		// ����һ�����ļ�,������ļ���skin�����ڣ��ͻ��׳��쳣
		f.createNewFile();
		// ���Դ���һ�����ļ�֮ǰ��ͨ�����ᴴ����Ŀ¼
		f.getParentFile().mkdirs();

		// �г����е��̷�c: d: e: �ȵ�
		f.listRoots();

		// �h���ļ�
		f.delete();

		// JVM������ʱ�򣬄h���ļ�����������ʱ�ļ���ɾ��
		f.deleteOnExit();
	}

}
