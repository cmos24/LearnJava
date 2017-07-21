package pers.oyxx.someDemo.InputOutput;

import java.io.File;

//文件常用方法2
public class TestFile3 {

	public static void main(String[] args) throws Exception {
		File f = new File("h:/TestFile3.txt");
		// 以字符串数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹），f必须是文件夹
/*		String[] str = f.list();
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
*/		// 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
		File[] fs = f.listFiles();
		// 以字符串形式返回获取所在文件夹
		f.getParent();

		// 以文件形式返回获取所在文件夹
		f.getParentFile();
		// 创建文件夹，如果父skin文件夹不存在，创建就无效
		f.mkdir();

		// 创建文件夹，如果父skin文件夹不存在，就会创建父文件夹
		f.mkdirs();

		// 创建一个空文件,如果父文件夹skin不存在，就会抛出异常
		f.createNewFile();
		// 所以创建一个空文件之前，通常都会创建父目录
		f.getParentFile().mkdirs();

		// 列出所有的盘符c: d: e: 等等
		f.listRoots();

		// 刪除文件
		f.delete();

		// JVM结束的时候，刪除文件，常用于临时文件的删除
		f.deleteOnExit();
	}

}
