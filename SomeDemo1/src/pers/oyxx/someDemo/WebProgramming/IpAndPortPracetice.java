package pers.oyxx.someDemo.WebProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*首先获取 获取本机IP地址，比如说是192.168.2.100。 那么本网段的ip地址就是从 192.168.2.1 到 192.168.2.255
再通过使用java 执行ping命令 判断这些ip地址能否使用，把能够使用的ip打印出来*/
//步骤 6 : 练习-判断本网段有多少可用的ip地址
public class IpAndPortPracetice {
	/*为了提高效率，使用多线程方式同时ping。 但是如果开启255个线程，又会因为网络端口太拥挤，会被判定为无法ping通。
	所以本例使用java自带线程池，线程池的连接数还不能太大，启动了15个线程。 
	
	等待所有的线程结束后打印出ping通了的ip地址。*/
	public static void main(String[] args) throws IOException, UnknownHostException{
		InetAddress host=InetAddress.getLocalHost();
		String ip =host.getHostAddress();
		String ipRange=ip.substring(0,ip.lastIndexOf('.'));//获得字符串中的最后一个点
		System.out.println("本机ip地址："+ip);
		System.out.println("网段是："+ipRange);

		//初始化存放ip的容器，将存放ip的容器转换成线程安全的
		List<String> ips=Collections.synchronizedList(new ArrayList<>());
		//初始化线程池
		ThreadPoolExecutor threadPool =new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, 
			new LinkedBlockingDeque<Runnable>());
		AtomicInteger number=new AtomicInteger();
		for(int i=0;i<255;i++){
			String testIP=ipRange+"."+(i+1);//拼成地址
			threadPool.execute(new Runnable(){
				@Override
				public void run(){
					boolean reachable=isReachable(testIP);
					if(reachable)
						System.out.println("找到可连接的ip地址：" + testIP);
						ips.add(testIP);
					
					synchronized(number){
							System.out.println("已经完成："+number.incrementAndGet()+"个ip测试");
					}
				}
			});
		}


	}

	private static boolean isReachable(String ip){
		try {
			boolean reachable=false;
			// Windows下调用系统命令:Process proc =Runtime.getRuntime().exec(命令);
			Process p=Runtime.getRuntime().exec("ping "+ip);
			BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line =null;
			StringBuilder sb=new StringBuilder();
			//将ping返回的信息按照格式存入到StringBuilder中
			while((line=br.readLine())!=null){
				if(line.length()!=0){
					sb.append(line+"\r\n");
				}
			}
		//当有time出现的时候，就表示连通了
		reachable=sb.toString().contains("time<");
		br.close();
		return reachable;
		} catch (IOException e) {
			//TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

}
