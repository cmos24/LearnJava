package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*������ָ���ǿ���ֱ�Ӱ�һ��������������ʽ����������Ľ��ʣ�����Ӳ�� 
һ��������������ʽ���д��䣬�������л��� �ö�������Ӧ���࣬������ʵ��Serializable�ӿ�*/


/*����һ��Hero��������������Ϊgaren�� 
�Ѹö������л���һ���ļ�garen.lol��
Ȼ����ͨ�����л��Ѹ��ļ�ת��Ϊһ��Hero����

ע����һ������ʵ������һ��ǰ���࣬���������࣬����ʵ����Serializable�ӿ�*/

//���л�һ������,������������������ֽ���
public class ObjectStream {
	public static void main(String[] args){
		//����һ��Hero garen
        //Ҫ��Hero����ֱ�ӱ������ļ��ϣ������Hero��ʵ��Serializable�ӿ�
		Hero h=new Hero();
		h.name="garen";
		h.hp=616;
		
		//׼��һ���ļ����ڱ���ö���
		File f=new File("h:/garen.lol");
		
		try(
				//�������������
				FileOutputStream fos=new FileOutputStream(f);
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				//��������������
				FileInputStream fis=new FileInputStream(f);
				ObjectInputStream ois=new ObjectInputStream(fis);				
			)
		{
			oos.writeObject(h);
			Hero h2=(Hero)ois.readObject();
			System.out.println(h2.name);
			System.out.println(h2.hp);
		}catch(IOException e1){
			e1.printStackTrace();
		}catch(ClassNotFoundException e2){
			e2.printStackTrace();//��ӦHero h2=(Hero)ois.readObject();
		}
	}
}
