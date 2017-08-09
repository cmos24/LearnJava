package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*׼��һ���ı��ļ�(�Ƕ�����)�����а���ASCII����ַ��������ַ���
���һ������:
 
public static void encodeFile(File encodingFile, File encodedFile);
 
�����㷨�� 
���֣�
�������9�����֣���ԭ���Ļ����ϼ�1������5���6, 3���4
�����9�����֣����0
��ĸ�ַ���
����Ƿ�z�ַ��������ƶ�һ��������d���e, G���H
�����z��z->a, Z-A��
�ַ���Ҫ������Сд
����ĸ�ַ�
����',&^ �������䣬����Ҳ��������
���飺 ʹ����ǰѧϰ����ϰ���е�ĳ��Java�ļ�������ѭ����ϰ�����кܶ���ַ�������*/

//���ַ�������������ļ����ܣ�����ͬ��
public class FileEncrypt {
	static File eFile = null;
	// ����������а�encodingFile�����ݽ��м��ܣ�Ȼ�󱣴浽encodedFile�ļ��С�
	public static void encodeFile(File encodingFile, File encodedFile) {

		char[] all=new char[(int)encodingFile.length()];
		try(FileReader fr=new FileReader(encodingFile)){
			fr.read(all);
			System.out.println("ԭ�ļ������ݣ�");
			for(char each:all){
				System.out.printf("%s",each);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		try(FileWriter fw=new FileWriter(encodedFile)){
			for(int i=0;i<all.length;i++){
				if(all[i]>=48&all[i]<=57){//�ж��Ƿ�Ϊ����
					if(48==all[i]){
						all[i]='9';
					}else{
						all[i]-=1;
					}
				}else{
					if(all[i]>=65&all[i]<=90){//�ж��Ƿ�Ϊ��д��ĸ
						if(65==all[i]){
							all[i]='Z';
						}else{
							//�����ַ���ASCII�벻������֮�䰴ת��תȥ��charֱ�Ӽ�ȥ�����Ϳ���ʵ��ASCII���ȥ��Ӧ������
							/*c=(int)all[i];
							all[i]=(char)(c-1);*/
							all[i]-=1;
						}
					}else{
						if(all[i]>=97&all[i]<=122){//�ж��Ƿ�ΪСд��ĸ
							if(97==all[i]){
								all[i]='z';
							}else{
								all[i]-=1;
							}
						}
					}
				}
			}
			//���ܽ�����д���ļ�
			fw.write(all);			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		try(FileReader fr=new FileReader(encodedFile)){
			fr.read(all);
			System.out.println();
			System.out.println("���ܺ��ļ������ݣ�");
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
