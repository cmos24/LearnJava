package pers.oyxx.someDemo.WebProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatAndroidClient {

	public static void main(String[] args) {
		try {
			Socket s=new Socket("127.0.0.1",8888);
			
			InputStream is=s.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			OutputStream os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			
			while(true){
				//∑¢ÀÕ
				Scanner scanner =new Scanner(System.in);
				String str=scanner.nextLine();
				dos.writeUTF(str);
				//Ω” ’
				String msg=dis.readUTF();
				System.out.println(msg);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
