package pers.oyxx.someDemo.WebProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
  
public class SocketPractice1CAnswer {
  
    public static void main(String[] args) {
  
        try {
            Socket s = new Socket("127.0.0.1", 8888);
  
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            //ֱ���÷��͸�����˵�Socket���ͷ����ͨ��
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
              
            while(true){//����д�������ݱ�����������Ϣ���棬ֻ���ȷ����գ�����������
                Scanner sc = new Scanner(System.in);
                String str = sc.next();
                dos.writeUTF(str);
                String msg = dis.readUTF();
                System.out.println("�յ��������Ϣ"+msg);
            }
              
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
