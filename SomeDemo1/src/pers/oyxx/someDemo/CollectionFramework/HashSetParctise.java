package pers.oyxx.someDemo.CollectionFramework;

import java.util.HashSet;

//HashSet��ϰ
public class HashSetParctise {
	/*�ڱȽ��ַ����½ڣ���һ��ͬ������ϰ
	����һ��������100���ַ�������
	ʹ�ó�����2������ַ������ַ�������
	ͳ������ַ����������ظ����ַ����ж�����
	ʹ��HashSet������������*/
	public static void main(String[] args) {
		//��ʼ������ַ�����
		String[] str=new String[100];
		for(int i=0;i<str.length;i++){
			str[i]=getRandomString(2);
			System.out.print(str[i]+",");
		}
		System.out.println();
		//ͳ���ظ��ַ���
		howManyRepeat(str);
		
		
	}//main����β��

	public static void howManyRepeat(String[] str){
		int repeatNum=0;
		String[] result = new String[str.length];
		HashSet<String> hs=new HashSet<String>();
		for(String s:str){
			if(!hs.add(s)){
				for(int i=0;i<result.length;i++){
					//�������ظ��ַ����Ѿ�������һ�ξͲ�������������
					if(!s.equals(result[i])){//�������ظ��ַ�����������û������ַ����Ļ�˵�����µ��ظ���������֮ǰ�Ѿ���⵽��
						result[repeatNum]=s;
						repeatNum++;
						System.out.printf("�ظ��ַ���%d:%s%n",repeatNum,s);
						break;
					}					
				}															
			}
		}
		System.out.println("��"+repeatNum+"���ظ��ַ���");		
	}
	
	//���2������ַ�
	public static String getRandomString(int length){
		String org="abcdefghifklmnopqrstuvwxyzABCDEFGHIJKLNMOPQRSTUVWXYZ0123456789";
		String result="";
		for(int i=0;i<length;i++){
			result+=org.charAt((int)(Math.random()*org.length()));
		}
		/*int beginIndex1=(int)(Math.random()*org.length());
		int beginIndex2=(int)(Math.random()*org.length());
		String first=org.substring(beginIndex1, beginIndex1+1);
		String second=org.substring(beginIndex2,beginIndex2+1);
		return first+second;*/
		
		return result;
	}
}
