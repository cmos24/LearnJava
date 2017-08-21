package pers.oyxx.someDemo.CollectionFramework;

//�Զ�������Hashcode�ķ���-��ϰ-�Զ����ַ�����hashcode
public class MyHashcode {
	/*
	 * ������Java API�ṩ��String��hashcode���ɰ취��
	 * 
	 * s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
	 * 
	 * 
	 * s[0] ��ʾ��һλ�ַ� n��ʾ�ַ����ĳ���
	 * ����ϰ������Ҫ��ȥ�������㷨�������Զ���һ���򵥵�hashcode�㷨�����������ַ�����hashcode
	 * ��ΪString�಻�ܱ���д����������ͨ��һ����̬����������һ��String��hashcode
	 * 
	 * public static int hashcode(String)
	 * 
	 * 
	 * ����ַ���������0���򷵻�0�� ���� ��ȡÿһλ�ַ���ת�������ֺ���ӣ�������23
	 * 
	 * (s[0]+ s[1] + s[2] + s[3]+ s[n-1])*23.
	 * 
	 * 
	 * ���ֵ������1999����ȡ2000����������֤����0-1999֮�䡣 ����Ǹ�������ȡ����ֵ��
	 * 
	 * ������ɳ�����2-10�Ĳ��ȵ�100���ַ�������ӡ�ñ�hashcode��ȡ��ֵ�ֱ��Ƕ���
	 */

	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			System.out.printf("%s���Զ���hashcode�ǣ�%d%n",getRandomString(),hashcode(getRandomString()));
		}		
	}

	// ������ɳ�����2-10�Ĳ��ȵ�100���ַ���
	private static String getRandomString() {
		String randomString = "";
		String org = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		for (int i = 0; i < (Math.random() * 8 + 2); i++) {
			randomString += org.charAt((int) ((Math.random() * org.length())));
		}
		return randomString;
	}
	
	//վ��д����������ַ�������
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

	// ����hashcode
	static int hashcode(String key) {
		int hashcode = 0;
		if (null != key) {
			char[] cs = key.toCharArray();
			// ÿ���ַ�׼��������
			int[] is = new int[cs.length];
			for (int i = 0; i < cs.length; i++) {
				is[i] = (int) cs[i];
			}
			// ʵ���㷨����ȡÿһλ�ַ���ת�������ֺ���ӣ�������23������1999��С��0ʱ��������
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
