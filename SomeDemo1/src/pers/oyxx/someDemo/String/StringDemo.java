package pers.oyxx.someDemo.String;

import java.util.Random;

public class StringDemo {//字符串以及字符变量的练习
	//随机生成5个字母+数字的字符串
	public String get5randomString(){
		char randomChars[] = new char[5];
		Random random = new Random();
		int randomNum;		
		for(int i=0;i<5;i++){
			if(0==random.nextInt(2)){
				randomNum=random.nextInt(9)+48;//在数字0~9中随机
			}else{
				randomNum=random.nextInt(25)+97;//在小写字母a~z中随机
			}
			randomChars[i]=(char)(randomNum);
		}
		String randomString = new String(randomChars);
		return randomString;
	}
	
	//生成随机字符数组
	public String[] getrandomStringGroup(){
		String[] randomStringGroup= new String[8];
		for(int i=0;i<8;i++){
			randomStringGroup[i]=get5randomString();
			System.out.println("数组元素"+(i+1)+"："+randomStringGroup[i]);
		}
		return randomStringGroup;
	}
	
	//对随机字符数组进行首字母排序
	public void rankStringGroup(String[] randomStringGroup){
		String [] group=randomStringGroup;
		String temp=null;
		short sn1,sn2;
		for(int j=0;j<(group.length-1);j++){
			for(int i=0;i<(group.length-1-j);i++){
				sn1=(short)group[i].charAt(0);//获得第i个字符串的第1个字符
//				System.out.println("sn1="+sn1);
				sn2=(short)group[i+1].charAt(0);//获得第i+1个字符串的第1个字符
//				System.out.println("sn2="+sn2);
				if(sn1>=sn2){
					temp = group[i];
					group[i]=group[i+1];
					group[i+1]=temp;
				}			
			}
		}
		for(int i=0;i<randomStringGroup.length;i++){
			System.out.println("排序后的数组元素"+(i+1)+"："+randomStringGroup[i]);
		}
	}
}
