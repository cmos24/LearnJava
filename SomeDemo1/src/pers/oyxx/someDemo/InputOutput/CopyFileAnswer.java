package pers.oyxx.someDemo.InputOutput;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//复制目标文件到源文件
public class CopyFileAnswer {
	     
	    /**
	     * 
	     * @param srcPath 源文件
	     * @param destPath 目标文件
	     */
	    public static void copyFile(String srcPath, String destPath){
	          
	        File srcFile = new File(srcPath);
	        File destFile = new File(destPath);
	        
	        //缓存区，一次性读取1024字节
	        byte[] buffer = new byte[1024];
	  
	        try (
	                FileInputStream fis = new FileInputStream(srcFile);
	                FileOutputStream fos = new FileOutputStream(destFile);
	        		BufferedOutputStream bos=new BufferedOutputStream(fos);
	        ){
	            while(true){
	                //实际读取的长度是 actuallyReaded,有可能小于1024
	                int actuallyReaded = fis.read(buffer);
	                //-1表示没有可读的内容了
	                if(-1==actuallyReaded)
	                    break;
	                bos.write(buffer, 0, actuallyReaded);
	                //fos.write(buffer, 0, actuallyReaded);//直接用缓存的写法
	                //不等缓存装满，直接将缓存中的内容写入到硬盘中，是FileOutputStream的父类OutputStream的方法，但是只对BufferedOutputStream有效
	                bos.flush();
	                //fos.flush();//直接用缓存的写法
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	          
	    }
	      
	    /**
	     * 
	     * @param srcPath 源文件夹
	     * @param destPath 目标文件夹
	     */
	    public static void copyFolder(String srcPath, String destPath){
	          
	    }
	      
	    public static void main(String[] args) {
	          
	        copyFile("h:/lol111.txt", "h:/lol222.txt");
	         
	    }

}
