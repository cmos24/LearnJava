package pers.oyxx.someDemo.JavaReflect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//������÷�����ϰ
/*������һ����ϰ ��ϰ-ͨ�������ļ���ȡ���󣬰�hero.config�Ķ���Ϊ֧�����¸�ʽ��
 
charactor.APHero
gareen
charactor.ADHero
teemo

���ȸ�����������ļ���ʹ�÷���ʵ����������Ӣ�۳�����
Ȼ��ͨ�������������Ӣ���������ƣ�������ͨ�����䣬���õ�һ��Ӣ�۵�attackHero�����������ڶ���Ӣ��*/
public class CallMethodPractice {
	
	public static void main(String[] args) {
		File configFile=new File("h:/hero1.config");
		if(!configFile.exists()){
			return;
		}
		
		
		try(FileReader fr=new FileReader(configFile);
			BufferedReader br=new BufferedReader(fr);
		){//��ȡ�����ļ�����
			char[] content=new char[(int)(configFile.length())];
			br.read(content);
			//�ûس��������ָ��ַ������ֿ�����ļ���ÿһ�е�����
			String[] fileContent=new String(content).split("\r\n");
			String hero1ClassName=fileContent[0];
			String hero1Name=fileContent[1];
			String hero2ClassName=fileContent[2];
			String hero2Name=fileContent[3];
			
			//ͨ������ʵ����2��Ӣ�۶���
			Class h1=Class.forName(hero1ClassName);
			Constructor c1=h1.getConstructor();
			Hero3 hero1=(Hero3)c1.newInstance();
            
			
			Class h2=Class.forName(hero2ClassName);
			Constructor c2=h2.getConstructor();
			Hero3 hero2=(Hero3)c2.newInstance();
//			Object hero2=c2.newInstance();//����дҲ����
			
			//ͨ���������2��Ӣ����������
//			Field f1=hero1.class.getDeclaredField("name");//��������д��Ϊhero1��һ��ʵ���������Ķ���class����Ӧ����������
//			Field f1=hero1.getClass().getDeclaredField("name");//Ϊʲô����дset֮��hero1��name����null?
//			Field f1=Hero3.class.getDeclaredField("name");//����д����
//			Field f1=hero1.getClass().getSuperclass().getDeclaredField("name");//����дҲ����
			
			//Field f1=h1.getDeclaredField("name");
			/*�������һ������д�ᱨ��
			 java.lang.NoSuchFieldException: name
				at java.lang.Class.getDeclaredField(Unknown Source)
				at pers.oyxx.someDemo.JavaReflect.CallMethodPractice.main(CallMethodPractice.java:60)			  
			 * */			

			Field f1=h1.getField("name");//����д����
			f1.setAccessible(true);//�����������getField��õ��ֶ�������
			f1.set(hero1, hero1Name);
//			System.out.println(hero1.name);
			
			Field f2=Hero3.class.getDeclaredField("name");
			f2.setAccessible(true);
			f2.set(hero2, hero2Name);
//			System.out.println(hero2.name);
			
			/*�ܽ᣺��getDeclaredField�������ĳ�ֶ������õĻ�Ҫ��Ŀ����ĸ�����󣨻����ֶ����ڵ��������������name�ֶ��Ǵ�����Hero3�еģ��Ż�ɹ�
			 * ����getField����ֶεĻ�����ֱ������Ŀ�������
			 * getField ֻ�ܻ�ȡpublic�ģ������Ӹ���̳������ֶΡ�
			   getDeclaredField ���Ի�ȡ�������е��ֶΣ�����private�ģ����ǲ��ܻ�ȡ�̳������ֶΡ� (ע�� ����ֻ�ܻ�ȡ��private���ֶΣ��������ܷ��ʸ�private�ֶε�ֵ,���Ǽ���setAccessible(true))
			 * */
			
			//ͨ�����䣬���õ�һ��Ӣ�۵�attackHero�����������ڶ���Ӣ��
			Method attackHero=h1.getMethod("attackHero", Hero3.class);
			attackHero.invoke(hero1, hero2);
			
		}catch(IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		
	}

}
