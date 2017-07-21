package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

//将一个文件拆分成几个部分
public class SplitFile {

	public static void main(String[] args) {
		int eachSize = 100 * 1024; // 100k
		File srcFile = new File("h:/TestPic.jpg");
		splitFile(srcFile, eachSize);
	}

	/**
	 * 拆分的思路，先把源文件的所有内容读取到内存中，然后从内存中挨个分到子文件里
	 * 
	 * @param srcFile
	 *            要拆分的源文件
	 * @param eachSize
	 *            按照这个大小，拆分
	 */
	private static void splitFile(File srcFile, int eachSize) {

		if (0 == srcFile.length())
			throw new RuntimeException("文件长度为0，不可拆分");

		byte[] fileContent = new byte[(int) srcFile.length()];
		// 先把文件读取到数组中
		try {
			FileInputStream fis = new FileInputStream(srcFile);
			fis.read(fileContent);
			fis.close();// 使用后关闭输入流
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 计算需要被划分成多少份子文件
		int fileNumber;
		// 文件是否能被整除得到的子文件个数是不一样的
		// (假设文件长度是25，每份的大小是5，那么就应该是5个)
		// (假设文件长度是26，每份的大小是5，那么就应该是6个)
		if (0 == fileContent.length % eachSize)
			fileNumber = (int) (fileContent.length / eachSize);
		else
			fileNumber = (int) (fileContent.length / eachSize) + 1;

		for (int i = 0; i < fileNumber; i++) {
			String eachFileName = srcFile.getName() + "-" + i;
			File eachFile = new File(srcFile.getParent(), eachFileName);
			byte[] eachContent;

			// 从源文件的内容里，复制部分数据到子文件
			// 除开最后一个文件，其他文件大小都是100k
			// 最后一个文件的大小是剩余的
			if (i != fileNumber - 1) // 不是最后一个
				eachContent = Arrays.copyOfRange(fileContent, eachSize * i, eachSize * (i + 1));
			else // 最后一个
				eachContent = Arrays.copyOfRange(fileContent, eachSize * i, fileContent.length);

			try {
				// 写出去
				FileOutputStream fos = new FileOutputStream(eachFile);
				fos.write(eachContent);
				// 记得关闭
				fos.close();
				System.out.printf("输出子文件%s，其大小是 %d字节%n", eachFile.getAbsoluteFile(), eachFile.length());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
