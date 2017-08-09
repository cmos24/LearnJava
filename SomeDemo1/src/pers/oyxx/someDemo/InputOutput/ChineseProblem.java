package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/*FileReader�õ������ַ�������һ�����Ѿ����ֽڸ���ĳ�ֱ���ʶ������ַ���
��FileReaderʹ�õı��뷽ʽ��Charset.defaultCharset()�ķ���ֵ����������ĵĲ���ϵͳ������GBK
FileReader�ǲ����ֶ����ñ��뷽ʽ�ģ�Ϊ��ʹ�������ı��뷽ʽ��ֻ��ʹ��InputStreamReader�����棬��������
 
new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8")); 
 

�ڱ����У��ü��±����ΪUTF-8��ʽ��Ȼ����UTF-8����ʶ���Ӧ�������ˡ�

���ͣ� Ϊʲô����ǰ����һ��?
�����ʹ�ü��±����ΪUTF-8�ĸ�ʽ����ô�ڵ�һ���ֽ���һ����ʾ��������BOM������־����ļ�ʱ��UTF-8������ġ�

*/

//������������
public class ChineseProblem {
	
	public static void main(String[] args){
		File f=new File("h:/TestFile2.txt");
		char[] all=new char[(int)f.length()];
		System.out.println("Ĭ�ϱ��뷽ʽ��"+Charset.defaultCharset());
		//FileReader�õ������ַ�������һ�����Ѿ����ֽڸ���ĳ�ֱ���ʶ������ַ���
        //��FileReaderʹ�õı��뷽ʽ��Charset.defaultCharset()�ķ���ֵ����������ĵĲ���ϵͳ������GBK
		try(FileReader fr=new FileReader(f)){
			fr.read(all);
			System.out.printf("FileReader��ʹ��Ĭ�ϵı��뷽ʽ%s,ʶ��������ַ��ǣ�%n",Charset.defaultCharset());
			System.out.println(new String(all));						
		}catch(IOException e){
			e.printStackTrace();
		}
		//FileReader�ǲ����ֶ����ñ��뷽ʽ�ģ�Ϊ��ʹ�������ı��뷽ʽ��ֻ��ʹ��InputStreamReader������
        //����ʹ��new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8")); ��������ʽ
		try(InputStreamReader isr=new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8"))){
			isr.read(all);
			System.out.printf("InputStreamReader ָ�����뷽ʽUTF-8,ʶ��������ַ��ǣ�%n");
            System.out.println(new String(all));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
