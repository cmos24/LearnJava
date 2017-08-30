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

	//数据库中没有相对应的回答的时候的回复
	private static List<String> cannotUnderstand= new ArrayList<String>();
	static{
		cannotUnderstand.add("听求不懂啊");
        cannotUnderstand.add("说人话");
        cannotUnderstand.add("再说一遍？");
        cannotUnderstand.add("大声点");
        cannotUnderstand.add("老子在忙，一边玩儿去");
	}
	
	public static void main(String[] args) {
		try{
			ServerSocket ss=new ServerSocket(8888);
			System.out.println("正在监控8888端口");
			Socket s=ss.accept();
			
			InputStream is=s.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			OutputStream os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			
			while(true){
				String msg=dis.readUTF();
				System.out.println(msg);
				//把机器人词库中对应的回复缓存下来
				List<Dictionary> ds=new DictionaryDAO().query(msg);
				//如果没有对应的记录
				if(ds.isEmpty()){
					Collections.shuffle(cannotUnderstand);
					dos.writeUTF(cannotUnderstand.get(0));
				}else{//有对应记录
					Collections.shuffle(ds);//乱序
					dos.writeUTF(ds.get(0).response);					
				}
				
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
