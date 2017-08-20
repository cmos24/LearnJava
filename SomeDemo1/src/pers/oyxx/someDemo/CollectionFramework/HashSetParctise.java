package pers.oyxx.someDemo.CollectionFramework;

import java.util.HashSet;

//HashSet练习
public class HashSetParctise {
	/*在比较字符串章节，有一个同样的练习
	创建一个长度是100的字符串数组
	使用长度是2的随机字符填充该字符串数组
	统计这个字符串数组里重复的字符串有多少种
	使用HashSet来解决这个问题*/
	public static void main(String[] args) {
		//初始化随机字符数组
		String[] str=new String[100];
		for(int i=0;i<str.length;i++){
			str[i]=getRandomString(2);
			System.out.print(str[i]+",");
		}
		System.out.println();
		//统计重复字符串
		howManyRepeat(str);
		
		
	}//main函数尾部

	public static void howManyRepeat(String[] str){
		int repeatNum=0;
		String[] result = new String[str.length];
		HashSet<String> hs=new HashSet<String>();
		for(String s:str){
			if(!hs.add(s)){
				for(int i=0;i<result.length;i++){
					//如果这个重复字符串已经被检测过一次就不再算进结果里了
					if(!s.equals(result[i])){//如果存放重复字符串的数组里没有这个字符串的话说明是新的重复，而不是之前已经检测到的
						result[repeatNum]=s;
						repeatNum++;
						System.out.printf("重复字符串%d:%s%n",repeatNum,s);
						break;
					}					
				}															
			}
		}
		System.out.println("有"+repeatNum+"个重复字符串");		
	}
	
	//获得2个随机字符
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
