package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileEncryptAnswer {
	 
	    /**
	     * 
	     * @param encodingFile
	     *            被加密的文件
	     * @param encodedFile
	     *            加密后保存的位置
	     */
	    public static void encodeFile(File encodingFile, File encodedFile) {
	 
	        try (FileReader fr = new FileReader(encodingFile); FileWriter fw = new FileWriter(encodedFile)) {
	            // 读取源文件
	            char[] fileContent = new char[(int) encodingFile.length()];
	            fr.read(fileContent);
	            System.out.println("加密前的内容：");
	            System.out.println(new String(fileContent));
	 
	            // 进行加密
	            encode(fileContent);
	            // 把加密后的内容保存到目标文件
	            System.out.println("加密后的内容：");
	            System.out.println(new String(fileContent));
	 
	            fw.write(fileContent);
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	 
	    private static void encode(char[] fileContent) {
	        for (int i = 0; i < fileContent.length; i++) {
	            char c = fileContent[i];
	            if (isLetterOrDigit(c)) {
	                switch (c) {
	                case '9':
	                    c = '0';
	                    break;
	                case 'z':
	                    c = 'a';
	                    break;
	                case 'Z':
	                    c = 'A';
	                    break;
	                default:
	                    c++;
	                    break;
	                }
	            }
	            fileContent[i] = c;
	        }
	    }
	 
	    public static boolean isLetterOrDigit(char c) {
	        // 不使用Character类的isLetterOrDigit方法是因为，中文也会被判断为字母
	        String letterOrDigital = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	        return -1 == letterOrDigital.indexOf(c) ? false : true;
	    }
	 
	    public static void main(String[] args) {
	        File encodingFile = new File("h:/FileEncryptTest.txt");
	        File encodedFile = new File("h:/FileEncryptTest3.txt");
	        encodeFile(encodingFile, encodedFile);
	    }
	}
