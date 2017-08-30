package pers.oyxx.someDemo.WebProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
 
public class SocketPractice1SAnswer {
 
    public static void main(String[] args) {
        try {
 
            ServerSocket ss = new ServerSocket(8888);
 
            System.out.println("�����ڶ˿ں�:8888");
            Socket s = ss.accept();
            
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            //ֱ�������ӽ����Ŀͻ��˵�Socket���Ͷ���ͨ�ţ������Լ��ٴ���һ��Socket������Ϣ
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
 
            while (true) {
                String msg = dis.readUTF();
                System.out.println("�յ��ͻ�����Ϣ"+msg);
                Scanner sc = new Scanner(System.in);
                String str = sc.next();
                dos.writeUTF(str);
            }
 
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
}
