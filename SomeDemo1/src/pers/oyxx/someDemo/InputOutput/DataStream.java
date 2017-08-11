package pers.oyxx.someDemo.InputOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*ʹ����������writeUTF()��readUTF() ���Խ������ݵĸ�ʽ��˳���д
�籾����ͨ��DataOutputStream ���ļ�˳��д�� ����ֵ���������ַ����� Ȼ����ͨ��DataInputStream ˳�������Щ���ݡ�

ע�� Ҫ��DataInputStream ��ȡһ���ļ�������ļ���������DataOutputStream д���ģ���������EOFException����ΪDataOutputStream ��д����ʱ�����һЩ�����ǣ�ֻ��DataInputStream ���ܳɹ��Ķ�ȡ��*/

//�������������ֽ���
public class DataStream {

	public static void main(String[] args) {
		write();
		read();
	}
	
	//��������д�����ݵ��ļ���
	static void write(){
		File f=new File("h:/DataStreamTestFile.txt");
		try(FileOutputStream fos=new FileOutputStream(f);DataOutputStream dos=new DataOutputStream(fos);){
			dos.writeBoolean(false);
			dos.writeInt(666);
			dos.writeInt(233);
//			dos.writeBoolean(true);
			dos.writeUTF("What's your name?");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	//����������ȡ���ݵ�������
	static void read(){
		File f=new File("h:/DataStreamTestFile.txt");
		try(FileInputStream fis=new FileInputStream(f);DataInputStream dis=new DataInputStream(fis);) {
			boolean b1=dis.readBoolean();
			int i1=dis.readInt();
			int i2=dis.readInt();
//			boolean b2=dis.readBoolean();
			String str=dis.readUTF();
			
			System.out.println("��ȡ������ֵ1��"+b1);
			System.out.println("��ȡ������1��"+i1);
			System.out.println("��ȡ������2��"+i2);
//			System.out.println("��ȡ������ֵ2��"+b2);
			System.out.println("��ȡ���ַ�����"+str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

