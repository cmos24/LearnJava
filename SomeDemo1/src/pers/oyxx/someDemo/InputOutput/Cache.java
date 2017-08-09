package pers.oyxx.someDemo.InputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*以介质是硬盘为例，字节流和字符流的弊端： 
在每一次读写的时候，都会访问硬盘。 如果读写的频率比较高的时候，其性能表现不佳。 
为了解决以上弊端，采用缓存流。 
缓存流在读取的时候，会一次性读较多的数据到缓存中，以后每一次的读取，都是在缓存中访问，直到缓存中的数据读取完毕，再到硬盘中区读取。 
就好比吃饭，不用缓存就是每吃一口都到锅里去铲。用缓存就是先把饭盛到碗里，碗里的吃完了，再到锅里去铲 
缓存流在写入数据的时候，会先把数据写入到缓存区，直到缓存区达到一定的量，才把这些数据，一起写入到硬盘中去。按照这种操作模式，就不会像字节流，字符流那样每写一个字节都访问硬盘，从而减少了IO操作*/

//缓存流
public class Cache {
	public static void main(String[] args) {
		// 示例 1 : 使用缓存流读取数据
		File f1 = new File("h:/TestFile4.txt");
		// 创建文件字符流
		// 缓存流必须建立在一个存在的流的基础上
		try (
				//创建文件字符流
				FileReader fr = new FileReader(f1); 
				//缓存流必须建立在一个存在的流的基础上
				BufferedReader br = new BufferedReader(fr);
			) 
		{
			while (true) {
				// 一次读一行
				String line = br.readLine();
				if (null == line)
					break;
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 示例 2 : 使用缓存流写出数据
		// 向文件"h:/TestFile.txt"中写入三行语句
		File f2 = new File("h:/TestFile.txt");
		try (
				//创建文件字符流
				FileWriter fw = new FileWriter(f2); 
				//缓存流必须建立在已存在的流的基础上
				PrintWriter pw = new PrintWriter(fw);
			) 
		{
			pw.println("第一行");
			pw.println("第二行");
			pw.println("第三行");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 示例 3 : flush
		// 有的时候，需要立即把数据写入到硬盘，而不是等缓存满了才写出去。 这时候就需要用到flush
		File f3 = new File("h:/TestFile.txt");
		try (
				//创建文件字符流
				FileWriter fw = new FileWriter(f3);
				//缓存流必须建立在已经存在的流的基础上
				PrintWriter pw = new PrintWriter(fw);
			) 
		{
			pw.println("这是第一行");
			//强制把缓存中的数据写入硬盘，无论缓存是否已满
			pw.flush();
			pw.println("这是第二行");
			pw.flush();
			pw.println("这是第三行");
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
