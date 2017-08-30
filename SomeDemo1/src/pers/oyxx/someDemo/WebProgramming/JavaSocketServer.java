package pers.oyxx.someDemo.WebProgramming;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//Socket-Server
public class JavaSocketServer {

	public static void main(String[] args) {
		/*步骤 1 : 建立连接 
		1. 服务端开启8888端口，并监听着，时刻等待着客户端的连接请求 
		2. 客户端知道服务端的ip地址和监听端口号，发出请求到服务端 
		客户端的端口地址是系统分配的，通常都会大于1024 
		一旦建立了连接，服务端会得到一个新的Socket对象，该对象负责与客户端进行通信。 
		注意： 在开发调试的过程中，如果修改过了服务器Server代码，要关闭启动的Server,否则新的Server
		不能启动，因为8888端口被占用了*/
		
		/*步骤 2 : 收发数字
		一旦建立了连接，服务端和客户端就可以通过Socket进行通信了 
		1. 客户端打开输出流，并发送数字 110 
		2. 服务端打开输入流，接受数字 110，并打印*/
		
		/* 步骤 3 : 收发字符串
		直接使用字节流收发字符串比较麻烦，使用数据流对字节流进行封装，这样收发字符串就容易了 
		1. 把输出流封装在DataOutputStream中 
		使用writeUTF发送字符串 "Legendary!" 
		2. 把输入流封装在DataInputStream 
		使用readUTF读取字符串,并打印*/
		
		//服务器打开端口8888
		try {
			ServerSocket ss=new ServerSocket(8888);			
			Socket s=ss.accept();
			
			System.out.println("有连接过来："+s);
			
			InputStream is=s.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			//读取客户端发送的数据
//			int msg=is.read();//接收字节流
			String msg=dis.readUTF();
			
			System.out.println("收到客户端发来的信息："+msg);
			dis.close();
//			is.close();
			s.close();
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
