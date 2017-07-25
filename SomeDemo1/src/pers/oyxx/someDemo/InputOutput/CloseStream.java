package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*所有的流，无论是输入流还是输出流，使用完毕之后，都应该关闭。 如果不关闭，会产生对资源占用的浪费。 
当量比较大的时候，会影响到业务的正常开展。*/

public class CloseStream {
	public static void main(String[] args){
		/*方法1 : 在try中关闭
		在try的作用域里关闭文件输入流，在前面的示例中都是使用这种方式，这样做有一个弊端；
		如果文件不存在，或者读取的时候出现问题而抛出异常，那么就不会执行这一行关闭流的代码，存在巨大的资源占用隐患。 不推荐使用*/
		try {
			File f=new File("h:/TestFile.txt");
			FileInputStream fis=new FileInputStream(f);
			byte[] all=new byte[(int)f.length()];
			fis.read(all);
			for(byte b:all){
				System.out.println(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
			  
		}
	}
}
