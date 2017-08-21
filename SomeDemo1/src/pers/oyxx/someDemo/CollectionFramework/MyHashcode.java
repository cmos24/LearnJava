package pers.oyxx.someDemo.CollectionFramework;

//自定义生成Hashcode的方法-练习-自定义字符串的hashcode
public class MyHashcode {
	/*
	 * 如下是Java API提供的String的hashcode生成办法；
	 * 
	 * s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
	 * 
	 * 
	 * s[0] 表示第一位字符 n表示字符串的长度
	 * 本练习并不是要求去理解这个算法，而是自定义一个简单的hashcode算法，计算任意字符串的hashcode
	 * 因为String类不能被重写，所以我们通过一个静态方法来返回一个String的hashcode
	 * 
	 * public static int hashcode(String)
	 * 
	 * 
	 * 如果字符串长度是0，则返回0。 否则： 获取每一位字符，转换成数字后，相加，最后乘以23
	 * 
	 * (s[0]+ s[1] + s[2] + s[3]+ s[n-1])*23.
	 * 
	 * 
	 * 如果值超过了1999，则取2000的余数，保证落在0-1999之间。 如果是负数，则取绝对值。
	 * 
	 * 随机生成长度是2-10的不等的100个字符串，打印用本hashcode获取的值分别是多少
	 */

	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			System.out.printf("%s的自定义hashcode是：%d%n",getRandomString(),hashcode(getRandomString()));
		}		
	}

	// 随机生成长度是2-10的不等的100个字符串
	private static String getRandomString() {
		String randomString = "";
		String org = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		for (int i = 0; i < (Math.random() * 8 + 2); i++) {
			randomString += org.charAt((int) ((Math.random() * org.length())));
		}
		return randomString;
	}
	
	//站长写的生成随机字符串方法
	private static String randomString(int length){
		String pool="";
		for(short i='0';i<=9;i++){
			pool+=(char)i;
		}
		for(short i='a';i<='z';i++){
			pool+=(char)i;
		}
		for(short i='A';i<='Z';i++){
			pool+=(char)i;
		}
		char[] cs=new char[length];
		for(int i=0;i<cs.length;i++){
			int index=(int)(Math.random()*pool.length());
			cs[i]=pool.charAt(index);
		}
		String result=new String(cs);
		return result;
	}

	// 生成hashcode
	static int hashcode(String key) {
		int hashcode = 0;
		if (null != key) {
			char[] cs = key.toCharArray();
			// 每个字符准换成数字
			int[] is = new int[cs.length];
			for (int i = 0; i < cs.length; i++) {
				is[i] = (int) cs[i];
			}
			// 实现算法：获取每一位字符，转换成数字后，相加，最后乘以23，超过1999和小于0时再作处理
			for (int each : is) {
				hashcode += each;
			}
			hashcode *= 23;
			if (hashcode < 0) {
				hashcode *= (-1);
			}
			if (hashcode > 1999) {
				hashcode %= 2000;
			}
		}
		return hashcode;
	}

}
