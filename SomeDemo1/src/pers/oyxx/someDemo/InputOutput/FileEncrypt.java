package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*准备一个文本文件(非二进制)，其中包含ASCII码的字符和中文字符。
设计一个方法:
 
public static void encodeFile(File encodingFile, File encodedFile);
 
加密算法： 
数字：
如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4
如果是9的数字，变成0
字母字符：
如果是非z字符，向右移动一个，比如d变成e, G变成H
如果是z，z->a, Z-A。
字符需要保留大小写
非字母字符
比如',&^ 保留不变，中文也保留不变
建议： 使用以前学习的练习题中的某个Java文件，比如循环练习，就有很多的字符和数字*/

//用字符输入输出流做文件加密，解密同理
public class FileEncrypt {
	static File eFile = null;
	// 在这个方法中把encodingFile的内容进行加密，然后保存到encodedFile文件中。
	public static void encodeFile(File encodingFile, File encodedFile) {

		char[] all=new char[(int)encodingFile.length()];
		try(FileReader fr=new FileReader(encodingFile)){
			fr.read(all);
			System.out.println("原文件的内容：");
			for(char each:all){
				System.out.printf("%s",each);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		try(FileWriter fw=new FileWriter(encodedFile)){
			for(int i=0;i<all.length;i++){
				if(all[i]>=48&all[i]<=57){//判断是否为数字
					if(48==all[i]){
						all[i]='9';
					}else{
						all[i]-=1;
					}
				}else{
					if(all[i]>=65&all[i]<=90){//判断是否为大写字母
						if(65==all[i]){
							all[i]='Z';
						}else{
							//操作字符的ASCII码不用类型之间按转来转去，char直接减去整数就可以实现ASCII码减去相应的整数
							/*c=(int)all[i];
							all[i]=(char)(c-1);*/
							all[i]-=1;
						}
					}else{
						if(all[i]>=97&all[i]<=122){//判断是否为小写字母
							if(97==all[i]){
								all[i]='z';
							}else{
								all[i]-=1;
							}
						}
					}
				}
			}
			//加密结束后写入文件
			fw.write(all);			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		try(FileReader fr=new FileReader(encodedFile)){
			fr.read(all);
			System.out.println();
			System.out.println("加密后文件的内容：");
			for(char each:all){
				System.out.printf("%s",each);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		FileEncrypt.encodeFile(new File("h:/FileEncryptTest.txt"),new File("h:/FileEncryptTest2.txt"));
	}
}
