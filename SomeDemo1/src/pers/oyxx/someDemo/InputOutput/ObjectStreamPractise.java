package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*��ϰ-���л�����
 ׼��һ��������10��������Hero�����飬ʹ��10��Hero�����ʼ��������
Ȼ��Ѹ��������л���һ���ļ�heros.lol
����ʹ��ObjectInputStream ��ȡ���ļ�����ת��ΪHero���飬��֤�������е����ݣ��Ƿ�����л�֮ǰһ��*/

//���л�����
public class ObjectStreamPractise {
	public static void main(String[] args) {
		File f=new File("h:/heros.lol");
		Hero[] hs=new Hero[10];
		for(int i=0;i<10;i++){
			hs[i]=new Hero("hero:"+i);
		}
		try(
				//��������������������ֽ������
				FileOutputStream fos=new FileOutputStream(f);
				ObjectOutputStream oos= new ObjectOutputStream(fos);
				//���������������������ֽ�������
				FileInputStream fis=new FileInputStream(f);
				ObjectInputStream ois=new ObjectInputStream(fis);				
			)
		{
			oos.writeObject(hs);
			Hero[] hs2=(Hero[])ois.readObject();
			System.out.println("�鿴���ļ��з����л������������е�ÿһ��Ԫ�أ�");
			for(Hero hero:hs2){
				System.out.println(hero.name);
			}
		}catch(IOException e1){
			e1.printStackTrace();
		}catch(ClassNotFoundException e2){
			e2.printStackTrace();
		}
	}
}
