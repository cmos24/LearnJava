package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*复制文件是常见的IO操作，设计如下方法，实现复制源文件srcFile到目标文件destFile

public static void copyFile(String srcFile, String destFile){
}
*/
//复制文件
public class CopyFile {

	public static void main(String[] args) {
		copyFile("h:/f1.txt","h:f22.txt");
	}
	/**
	 * 复制源文件到目标文件
	 * @param srcFile
	 * 	源文件
	 * @param destFile
	 * 	目标文件
	 */
	public static void copyFile(String srcFile,String destFile){
		File srcFile1=new File(srcFile);
		File destFile1=new File(destFile);
		//这样做不好，因为源文件可能很大，全部放到字符数组中很消耗内存，用缓存一点一点写入就会比较好（Answer类中的方法）
		byte[] fileCotent=new byte[(int)srcFile1.length()];
		try(
				FileInputStream fis=new FileInputStream(srcFile1);
				FileOutputStream fos=new FileOutputStream(destFile1);
			)
		{
			fis.read(fileCotent);
			fos.write(fileCotent);
			System.out.println("文件复制成功");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
