package pers.oyxx.someDemo.MultiThreading;

import java.util.ArrayList;
import java.util.List;

//常用线程方法练习-破解密码 
public class SomethingThreadFunctionsPractice2Answer {
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
	
	public static boolean found = false;
    
    public static void main(String[] args) {
        String password = randomString(3);
        System.out.println("密码是:" + password);
        List<String> passwords = new ArrayList<>();
         
        new PasswordThread(password,passwords).start();
        new LogThread(passwords).start();
         
    }

    private static String randomString(int length) {
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char) i;
        }
        char cs[] = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
		
	}

}
