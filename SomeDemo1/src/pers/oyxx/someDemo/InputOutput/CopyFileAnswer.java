package pers.oyxx.someDemo.InputOutput;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//����Ŀ���ļ���Դ�ļ�
public class CopyFileAnswer {
	     
	    /**
	     * 
	     * @param srcPath Դ�ļ�
	     * @param destPath Ŀ���ļ�
	     */
	    public static void copyFile(String srcPath, String destPath){
	          
	        File srcFile = new File(srcPath);
	        File destFile = new File(destPath);
	        
	        //��������һ���Զ�ȡ1024�ֽ�
	        byte[] buffer = new byte[1024];
	  
	        try (
	                FileInputStream fis = new FileInputStream(srcFile);
	                FileOutputStream fos = new FileOutputStream(destFile);
	        		BufferedOutputStream bos=new BufferedOutputStream(fos);
	        ){
	            while(true){
	                //ʵ�ʶ�ȡ�ĳ����� actuallyReaded,�п���С��1024
	                int actuallyReaded = fis.read(buffer);
	                //-1��ʾû�пɶ���������
	                if(-1==actuallyReaded)
	                    break;
	                bos.write(buffer, 0, actuallyReaded);
	                //fos.write(buffer, 0, actuallyReaded);//ֱ���û����д��
	                //���Ȼ���װ����ֱ�ӽ������е�����д�뵽Ӳ���У���FileOutputStream�ĸ���OutputStream�ķ���������ֻ��BufferedOutputStream��Ч
	                bos.flush();
	                //fos.flush();//ֱ���û����д��
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	          
	    }
	      
	    /**
	     * 
	     * @param srcPath Դ�ļ���
	     * @param destPath Ŀ���ļ���
	     */
	    public static void copyFolder(String srcPath, String destPath){
	          
	    }
	      
	    public static void main(String[] args) {
	          
	        copyFile("h:/lol111.txt", "h:/lol222.txt");
	         
	    }

}
