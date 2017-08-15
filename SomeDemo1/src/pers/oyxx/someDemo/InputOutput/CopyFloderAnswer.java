package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*�����ļ���,ʵ�����·�������Դ�ļ��������е��ļ� ���Ƶ�Ŀ���ļ�����(�������ļ���)

public static void copyFolder(String srcFolder, String destFolder){
	
}*/
//�����ļ����Լ����ļ�
public class CopyFloderAnswer {
	/**
	 * �����ļ�
	 * 
	 * @param srcPath
	 *            ԭ�ļ�
	 * @param destPath
	 *            Ŀ���ļ�
	 */
	public static void copyFile(String srcPath, String destPath) {
		File srcFile = new File(srcPath);
		File destFile = new File(destPath);
		// ��������һ�ζ�ȡ1024�ֽ�
		byte[] buffer = new byte[1024];
		try (FileInputStream fis = new FileInputStream(srcFile);
				FileOutputStream fos = new FileOutputStream(destFile);) {
			while (true) {
				// ʵ�ʶ�ȡ������actuallyReaded���п���С��1024
				int actuallyReaded = fis.read(buffer);
				// -1��ʾû�п��Զ���������
				if (-1 == actuallyReaded)
					break;
				fos.write(buffer, 0, actuallyReaded);
				fos.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����ļ����Լ����ļ�
	 * 
	 * @param srcPath
	 *            ԭ�ļ���
	 * @param destPath
	 *            Ŀ���ļ���
	 */
	public static void copyFolder(String srcPath, String destPath) {
		File srcFolder = new File(srcPath);
		File destFolder = new File(destPath);
		if (!srcFolder.exists())// ԭ�ļ��в�����
			return;
		if (!srcFolder.isDirectory())// ԭ�ļ��в���һ���ļ���
			return;
		if (destFolder.isFile())// Ŀ���ļ���һ���ļ�
			return;
		if (!destFolder.exists())// Ŀ���ļ��в�����
			destFolder.mkdirs();

		// ����ԭ�ļ���
		File[] fs = srcFolder.listFiles();
		for (File srcFile : fs) {
			// ������ļ����͸���
			if (srcFile.isFile()) {
				File newDestFile = new File(destPath, srcFile.getName());// ���Ŀ���ļ�����
				copyFile(srcFile.getAbsolutePath(), newDestFile.getAbsolutePath());
			}
			//������ļ��У��͵ݹ�
			if(srcFile.isDirectory()){
				File newDestFolder=new File(destPath,srcFile.getName());
				copyFolder(srcFile.getAbsolutePath(),newDestFolder.getAbsolutePath());
			}				
		}
		System.out.println("����"+destFolder.getAbsolutePath()+"�ɹ�");
	}

	public static void main(String[] args) {
		copyFolder("h:/TestFolder1","h:/TestFolder1-copy");
	}
}
