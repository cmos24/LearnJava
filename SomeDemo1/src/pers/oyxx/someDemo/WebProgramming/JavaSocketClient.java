package pers.oyxx.someDemo.WebProgramming;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

//Socket-Client
public class JavaSocketClient {

	public static void main(String[] args) {
		try {
			Socket s=new Socket("127.0.0.1",8888);
			System.out.println(s);
			
			OutputStream os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
//			os.write(123);//发送字节流
			
			//从控制台输入要发送的信息
			Scanner scanner=new Scanner(System.in);
			String msg=scanner.nextLine();
			
			dos.writeUTF(msg);
			
			dos.close();
//			os.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
