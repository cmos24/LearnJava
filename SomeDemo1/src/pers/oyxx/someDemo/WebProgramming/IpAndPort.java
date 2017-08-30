package pers.oyxx.someDemo.WebProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

//IP和端口
public class IpAndPort {
	/*
	 * 步骤 1 : IP地址 在网络中每台计算机都必须有一个的IP地址； 32位，4个字节，常用点分十进制的格式表示，例如：192.168.1.100
	 * 127.0.0.1 是固定ip地址，代表当前计算机，相当于面向对象里的 "this"
	 * 
	 */

	/*
	 * 步骤 2 : 端口 两台计算机进行连接，总有一台服务器，一台客户端。 服务器和客户端之间的通信通过端口进行。如图：
	 */

	/* 步骤 3 : 获取本机IP地址 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		InetAddress host = InetAddress.getLocalHost();
		String ip = host.getHostAddress();
		System.out.println("本机ip地址：" + ip);

		/*
		 * 步骤 4 : ping命令 使用ping判断一个地址是否能够到达
		 * ping不是java的api，是windows中的一个小工具，用于判断一个地址的相应时间
		 */

		/*
		 * 步骤 5 : 使用java 执行ping命令 借助 Runtime.getRuntime().exec()
		 * 可以运行一个windows的exe程序
		 */
		Process p = Runtime.getRuntime().exec("ping " + "www.baidu.com");//"ping"后面的空格一定要加
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = null;
		StringBuilder sb = new StringBuilder();// 用线程安全的StringBuffered接受数据，不用char[]装的原因是不知道接收数据的长度，不能初始化
		while ((line = br.readLine()) != null) {
			if (line.length() != 0) {
				sb.append(line + "\r\n");//将字符串逐行加到StringBuffered末尾，相比一次性加进去，逐行可以保留原来分行的格式
			}
		}
		System.out.println("本次指令返回的消息是：");
		System.out.println(sb.toString());

	}

}
