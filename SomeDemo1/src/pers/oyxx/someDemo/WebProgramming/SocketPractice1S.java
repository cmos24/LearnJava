package pers.oyxx.someDemo.WebProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Socket-练习-服务端和客户端互聊
/*前面部分的学习效果是服务端接受数据，客户端发送数据。

做相应的改动，使得服务端也能发送数据，客户端也能接受数据，并且可以一直持续下去*/
public class SocketPractice1S {
	// 显示当前时间
	public static String now() {
		return (new SimpleDateFormat("yy/MM/dd HH:mm:ss").format(new Date()));
	}

	public static void main(String[] args) {
		// 服务器线程-用于接收消息
		Thread t1 = new Thread() {
			public void run() {
				try (ServerSocket ss = new ServerSocket(8889);// 接收信息的Socket
				) {
					while (true) {

						// 获得消息
						Socket clientSocket = ss.accept();
						InputStream is = clientSocket.getInputStream();
						DataInputStream dis = new DataInputStream(is);
						String msg = dis.readUTF();
						// 输出消息
						System.out.println(now() + clientSocket + ":");
						System.out.println(msg);
						// 输出结束关闭数据流
						// dis.close();
					}

				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		};
		// 客户端线程-用于发送消息
		Thread t2 = new Thread() {
			public void run() {
				// 先等对面启动
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {//不能把thisSocket定义在try-with-source里面，否则只能发送一次，第二次会提示Socket closed
					while (true) {
						// 获得要发送的消息
						Socket thisSocket = new Socket("127.0.0.1", 8890);// 发送信息的Socket
						OutputStream os = thisSocket.getOutputStream();
						DataOutputStream dos = new DataOutputStream(os);
						Scanner scanner = new Scanner(System.in);
						String msg = scanner.nextLine();
						// 发送消息
						dos.writeUTF(msg);
						// 发送结束关闭数据流
						dos.close();
					}

				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		};

		t1.start();
		t2.start();

	}
}
