package pers.oyxx.someDemo.String;

import java.util.Random;

public class StringDemo {//�ַ����Լ��ַ���������ϰ
	//�������5����ĸ+���ֵ��ַ���
	public String get5randomString(){
		char randomChars[] = new char[5];
		Random random = new Random();
		int randomNum;		
		for(int i=0;i<5;i++){
			if(0==random.nextInt(2)){
				randomNum=random.nextInt(9)+48;//������0~9�����
			}else{
				randomNum=random.nextInt(25)+97;//��Сд��ĸa~z�����
			}
			randomChars[i]=(char)(randomNum);
		}
		String randomString = new String(randomChars);
		return randomString;
	}
	
	//��������ַ�����
	public String[] getrandomStringGroup(){
		String[] randomStringGroup= new String[8];
		for(int i=0;i<8;i++){
			randomStringGroup[i]=get5randomString();
			System.out.println("����Ԫ��"+(i+1)+"��"+randomStringGroup[i]);
		}
		return randomStringGroup;
	}
	
	//������ַ������������ĸ����
	public void rankStringGroup(String[] randomStringGroup){
		String [] group=randomStringGroup;
		String temp=null;
		short sn1,sn2;
		for(int j=0;j<(group.length-1);j++){
			for(int i=0;i<(group.length-1-j);i++){
				sn1=(short)group[i].charAt(0);//��õ�i���ַ����ĵ�1���ַ�
//				System.out.println("sn1="+sn1);
				sn2=(short)group[i+1].charAt(0);//��õ�i+1���ַ����ĵ�1���ַ�
//				System.out.println("sn2="+sn2);
				if(sn1>=sn2){
					temp = group[i];
					group[i]=group[i+1];
					group[i+1]=temp;
				}			
			}
		}
		for(int i=0;i<randomStringGroup.length;i++){
			System.out.println("����������Ԫ��"+(i+1)+"��"+randomStringGroup[i]);
		}
	}
}
