package pers.oyxx.someDemo.MultiThreading;

//�����̷߳�����ϰ-�ƽ����� 
public class SomethingThreadFunctionsPractice1 {
	/*
	 * 1. ����һ��������3������ַ�����������ַ�����Ϊ��������
	 * 
	 * 2. ����һ���ƽ��̣߳�ʹ����ٷ���ƥ���������
	 * 
	 * 3. ����һ����־�̣߳���ӡ���ù���Щ�ַ���ȥƥ�䣬�����־�߳����Ϊ�ػ��߳�
	 * 
	 * ��ʾ�� �ƽ��̰߳���ٷ����ɵĿ����������һ�������У���־�̲߳��ϵĴ�����������ó��������룬����ӡ������
	 * ������������ǿյģ�����Ϣ1�룬������ֲ��ǿյģ��Ͳ�ͣ��ȡ��������ӡ��
	 * 
	 */
	
	public static String password;
	
	//����ָ�����ȵ�����ַ���
	public static String getRandomString(int length){
		String randomString="";
		String pool="";
		for(short i='a';i<='z';i++){
			pool+=(char)i;
		}
		for(short i='A';i<='Z';i++){
			pool+=(char)i;
		}
		for(int i=0;i<=9;i++){
			pool+=i;
		}
		
		for(int i=0;i<length;i++){
			randomString+=pool.charAt((int)(Math.random()*pool.length()));
		}
		return randomString;
	}
	
	//��֤�����ܷ�ͨ��
	public static String Verification(String pw){
		if(password.equals(pw)){
			System.out.println("��֤�ɹ���");
			return "��֤�ɹ�";
		}else{
			System.out.println("�������");
			return "�������";
		}
	}
	
	public static void main(String[] args) {
		SomethingThreadFunctionsPractice1 stfp=new SomethingThreadFunctionsPractice1();
		//����3λ�������
		stfp.password=stfp.getRandomString(3);
		String password=stfp.password;
		System.out.println("����"+password);
		
		//�ƽ�����
		
	}

}
