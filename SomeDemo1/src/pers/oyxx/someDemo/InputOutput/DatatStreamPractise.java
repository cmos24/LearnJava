package pers.oyxx.someDemo.InputOutput;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
      
/*Ҫ��
��һ�ַ�ʽ�� ʹ�û������������������ַ�������ʽд���ļ�����û��������ַ�������ʽ��ȡ������Ȼ��ת��Ϊ�������֡� 
ע�� ��������֮��Ҫ�зָ��������������������֡� ����������31��15�������ʹ�÷ָ�������ô����3115����ȡ�������޷�ʶ�𵽵������������֡� ʹ�÷ָ���31@15�ܽ��������⡣

�ڶ��ַ�ʽ�� ʹ��������DataOutputStream���ļ�����д���������֣�Ȼ����DataInpuStream������ȡ��������*/

public class DatatStreamPractise {
    static File f =new File("h:/data.txt");
    static int x = 31;
    static int y = 15;
    public static void main(String[] args) {
         
        //��������ʽ
        method1();
        //��������ʽ
        method2();
    }
  
    private static void method2() {
        try (
                FileInputStream fis  = new FileInputStream(f);
                DataInputStream dis =new DataInputStream(fis);
                FileOutputStream fos  = new FileOutputStream(f);
                DataOutputStream dos =new DataOutputStream(fos);
                 
        ){
            dos.writeInt(x);
            dos.writeInt(y);
             
            int x = dis.readInt();
            int y = dis.readInt();//��������д��������е�������Ϣ��ǣ���ȡ��ʱ����Էֱ�ÿһ��
            System.out.printf("ʹ����������ȡ����x�� %d y�� %d%n",x,y);
             
        } catch (IOException e) {
            e.printStackTrace();
        }
         
    }
 
    private static void method1() {
         try (
                 FileWriter fw = new FileWriter(f);
                 PrintWriter pw = new PrintWriter(fw);
                 FileReader fr = new FileReader(f); 
                 BufferedReader br = new BufferedReader(fr);                 
                  
         ) {
             pw.print(x+"@"+y);
             pw.flush();
             String str = br.readLine();//�û�����д����ִ�ж�ȡ��Ϊÿ��д�������û�и�����Ϣ���Ի����һ���ֿܷ���ȡ��ֻ�����Ǽ��Ϸָ������ֿ�����
             String[] ss =str.split("@");//���ַ�������ĳ���ַ��ָ���طָ�������
             int x = Integer.parseInt(ss[0]);//int���͵Ĳ���
             int y = Integer.parseInt(ss[1]);
             System.out.printf("ʹ�û�������ȡ����x�� %d y�� %d%n",x,y);
              
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
    
    }
 
/*    private static void read() {
        File f =new File("h:/data.txt");
        try (
                FileInputStream fis  = new FileInputStream(f);
                DataInputStream dis =new DataInputStream(fis);
        ){
            boolean b= dis.readBoolean();
            int i = dis.readInt();
            String str = dis.readUTF();
              
            System.out.println("��ȡ������ֵ:"+b);
            System.out.println("��ȡ������:"+i);
            System.out.println("��ȡ���ַ���:"+str);
  
        } catch (IOException e) {
            e.printStackTrace();
        }
          
    }
  
    private static void write() {
        File f =new File("h:/data.txt");
        try (
                FileOutputStream fos  = new FileOutputStream(f);
                DataOutputStream dos =new DataOutputStream(fos);
        ){
            dos.writeBoolean(true);
            dos.writeInt(300);
            dos.writeUTF("123 this is gareen");
        } catch (IOException e) {
            e.printStackTrace();
        }
          
    }*/
}