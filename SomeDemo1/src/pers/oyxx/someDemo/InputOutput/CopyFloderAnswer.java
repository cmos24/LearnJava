package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*复制文件夹,实现如下方法，把源文件夹下所有的文件 复制到目标文件夹下(包括子文件夹)

public static void copyFolder(String srcFolder, String destFolder){
	
}*/
//复制文件夹以及子文件
public class CopyFloderAnswer {
	/**
	 * 复制文件
	 * 
	 * @param srcPath
	 *            原文件
	 * @param destPath
	 *            目标文件
	 */
	public static void copyFile(String srcPath, String destPath) {
		File srcFile = new File(srcPath);
		File destFile = new File(destPath);
		// 缓冲区，一次读取1024字节
		byte[] buffer = new byte[1024];
		try (FileInputStream fis = new FileInputStream(srcFile);
				FileOutputStream fos = new FileOutputStream(destFile);) {
			while (true) {
				// 实际读取长度是actuallyReaded，有可能小于1024
				int actuallyReaded = fis.read(buffer);
				// -1表示没有可以读的内容了
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
	 * 复制文件夹以及子文件
	 * 
	 * @param srcPath
	 *            原文件夹
	 * @param destPath
	 *            目标文件夹
	 */
	public static void copyFolder(String srcPath, String destPath) {
		File srcFolder = new File(srcPath);
		File destFolder = new File(destPath);
		if (!srcFolder.exists())// 原文件夹不存在
			return;
		if (!srcFolder.isDirectory())// 原文件夹不是一个文件夹
			return;
		if (destFolder.isFile())// 目标文件是一个文件
			return;
		if (!destFolder.exists())// 目标文件夹不存在
			destFolder.mkdirs();

		// 遍历原文件夹
		File[] fs = srcFolder.listFiles();
		for (File srcFile : fs) {
			// 如果是文件，就复制
			if (srcFile.isFile()) {
				File newDestFile = new File(destPath, srcFile.getName());// 获得目标文件对象
				copyFile(srcFile.getAbsolutePath(), newDestFile.getAbsolutePath());
			}
			//如果是文件夹，就递归
			if(srcFile.isDirectory()){
				File newDestFolder=new File(destPath,srcFile.getName());
				copyFolder(srcFile.getAbsolutePath(),newDestFolder.getAbsolutePath());
			}				
		}
		System.out.println("复制"+destFolder.getAbsolutePath()+"成功");
	}

	public static void main(String[] args) {
		copyFolder("h:/TestFolder1","h:/TestFolder1-copy");
	}
}
