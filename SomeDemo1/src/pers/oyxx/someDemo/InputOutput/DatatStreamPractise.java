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
      
/*要求
第一种方式： 使用缓存流把两个数字以字符串的形式写到文件里，再用缓存流以字符串的形式读取出来，然后转换为两个数字。 
注： 两个数字之间要有分隔符用于区分这两个数字。 比如数字是31和15，如果不使用分隔符，那么就是3115，读取出来就无法识别到底是哪两个数字。 使用分隔符31@15能解决这个问题。

第二种方式： 使用数据流DataOutputStream向文件连续写入两个数字，然后用DataInpuStream连续读取两个数字*/

public class DatatStreamPractise {
    static File f =new File("h:/data.txt");
    static int x = 31;
    static int y = 15;
    public static void main(String[] args) {
         
        //缓存流方式
        method1();
        //数据流方式
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
            int y = dis.readInt();//用数据流写入的数据有单独的信息标记，读取的时候可以分辨每一个
            System.out.printf("使用数据流读取出的x是 %d y是 %d%n",x,y);
             
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
             String str = br.readLine();//用缓存流写入再执行读取因为每次写入的内容没有附带信息所以会混在一起不能分开读取，只能我们加上分隔符来分开它们
             String[] ss =str.split("@");//将字符串按照某个字符分割，返回分割后的数组
             int x = Integer.parseInt(ss[0]);//int类型的拆箱
             int y = Integer.parseInt(ss[1]);
             System.out.printf("使用缓存流读取出的x是 %d y是 %d%n",x,y);
              
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
              
            System.out.println("读取到布尔值:"+b);
            System.out.println("读取到整数:"+i);
            System.out.println("读取到字符串:"+str);
  
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