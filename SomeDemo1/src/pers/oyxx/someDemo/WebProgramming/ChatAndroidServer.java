package pers.oyxx.someDemo.WebProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatAndroidServer {

	//���ݿ���û�����Ӧ�Ļش��ʱ��Ļظ�
	private static List<String> cannotUnderstand= new ArrayList<String>();
	static{
		cannotUnderstand.add("���󲻶���");
        cannotUnderstand.add("˵�˻�");
        cannotUnderstand.add("��˵һ�飿");
        cannotUnderstand.add("������");
        cannotUnderstand.add("������æ��һ�����ȥ");
	}
	
	public static void main(String[] args) {
		try{
			ServerSocket ss=new ServerSocket(8888);
			System.out.println("���ڼ��8888�˿�");
			Socket s=ss.accept();
			
			InputStream is=s.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			OutputStream os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			
			while(true){
				String msg=dis.readUTF();
				System.out.println(msg);
				//�ѻ����˴ʿ��ж�Ӧ�Ļظ���������
				List<Dictionary> ds=new DictionaryDAO().query(msg);
				//���û�ж�Ӧ�ļ�¼
				if(ds.isEmpty()){
					Collections.shuffle(cannotUnderstand);
					dos.writeUTF(cannotUnderstand.get(0));
				}else{//�ж�Ӧ��¼
					Collections.shuffle(ds);//����
					dos.writeUTF(ds.get(0).response);					
				}
				
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
