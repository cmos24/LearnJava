package pers.oyxx.someDemo.MultiThreading;

//密码破解线程
public class CrackPassword implements Runnable {
	private SomethingThreadFunctionsPractice1 stfp;
	private String pwPool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private int pwLength;
	private char[] pwChars;

	public CrackPassword(SomethingThreadFunctionsPractice1 stfp) {
		this.stfp = stfp;
		pwLength = stfp.password.length();
		pwChars = new char[pwLength];
	}

	public void run() {
		System.out.println("开始破解......");
		boolean flag = false;
		int pwLength = stfp.password.length();
		char[] pwChars = new char[pwLength];
		String pwPool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		for (int i = 0; i < pwLength; i++) {
			pwChars[i] = 'a';
		}
		for (int i = 0; i < pwPool.length(); i++) {
			for (int j = 0; j < pwPool.length(); j++) {
				pwChars[i] = pwPool.charAt(j);
				if (String.valueOf(pwChars).equals(stfp.password)) {
					System.out.println("破解成功，密码为：" + String.valueOf(pwChars));
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
	}

	/*private void crack() {
		for (int i = 0; i < pwPool.length(); i++) {
			pwChars[pwLength - 1] = pwPool.charAt(i);
		}
		if (1 != pwLength) {
			crack();
		}

	}*/

	
	
}
