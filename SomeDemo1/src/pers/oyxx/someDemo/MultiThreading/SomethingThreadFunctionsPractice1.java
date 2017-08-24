package pers.oyxx.someDemo.MultiThreading;

//常用线程方法练习-破解密码 
public class SomethingThreadFunctionsPractice1 {
	/*
	 * 1. 生成一个长度是3的随机字符串，把这个字符串作为当做密码
	 * 
	 * 2. 创建一个破解线程，使用穷举法，匹配这个密码
	 * 
	 * 3. 创建一个日志线程，打印都用过哪些字符串去匹配，这个日志线程设计为守护线程
	 * 
	 * 提示： 破解线程把穷举法生成的可能密码放在一个容器中，日志线程不断的从这个容器中拿出可能密码，并打印出来。
	 * 如果发现容器是空的，就休息1秒，如果发现不是空的，就不停的取出，并打印。
	 * 
	 */
	
	public static String password;
	
	//生成指定长度的随机字符串
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
	
	//验证密码能否通过
	public static String Verification(String pw){
		if(password.equals(pw)){
			System.out.println("验证成功！");
			return "验证成功";
		}else{
			System.out.println("密码错误");
			return "密码错误";
		}
	}
	
	public static void main(String[] args) {
		SomethingThreadFunctionsPractice1 stfp=new SomethingThreadFunctionsPractice1();
		//生成3位随机密码
		stfp.password=stfp.getRandomString(3);
		String password=stfp.password;
		System.out.println("密码"+password);
		
		//破解密码
		
	}

}
