package pers.oyxx.someDemo.WebProgramming;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//Socket-Server
public class JavaSocketServer {

	public static void main(String[] args) {
		/*���� 1 : �������� 
		1. ����˿���8888�˿ڣ��������ţ�ʱ�̵ȴ��ſͻ��˵��������� 
		2. �ͻ���֪������˵�ip��ַ�ͼ����˿ںţ��������󵽷���� 
		�ͻ��˵Ķ˿ڵ�ַ��ϵͳ����ģ�ͨ���������1024 
		һ�����������ӣ�����˻�õ�һ���µ�Socket���󣬸ö�������ͻ��˽���ͨ�š� 
		ע�⣺ �ڿ������ԵĹ����У�����޸Ĺ��˷�����Server���룬Ҫ�ر�������Server,�����µ�Server
		������������Ϊ8888�˿ڱ�ռ����*/
		
		/*���� 2 : �շ�����
		һ�����������ӣ�����˺Ϳͻ��˾Ϳ���ͨ��Socket����ͨ���� 
		1. �ͻ��˴������������������ 110 
		2. ����˴����������������� 110������ӡ*/
		
		/* ���� 3 : �շ��ַ���
		ֱ��ʹ���ֽ����շ��ַ����Ƚ��鷳��ʹ�����������ֽ������з�װ�������շ��ַ����������� 
		1. ���������װ��DataOutputStream�� 
		ʹ��writeUTF�����ַ��� "Legendary!" 
		2. ����������װ��DataInputStream 
		ʹ��readUTF��ȡ�ַ���,����ӡ*/
		
		//�������򿪶˿�8888
		try {
			ServerSocket ss=new ServerSocket(8888);			
			Socket s=ss.accept();
			
			System.out.println("�����ӹ�����"+s);
			
			InputStream is=s.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			//��ȡ�ͻ��˷��͵�����
//			int msg=is.read();//�����ֽ���
			String msg=dis.readUTF();
			
			System.out.println("�յ��ͻ��˷�������Ϣ��"+msg);
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
