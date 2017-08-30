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

/*���Ȼ�ȡ ��ȡ����IP��ַ������˵��192.168.2.100�� ��ô�����ε�ip��ַ���Ǵ� 192.168.2.1 �� 192.168.2.255
��ͨ��ʹ��java ִ��ping���� �ж���Щip��ַ�ܷ�ʹ�ã����ܹ�ʹ�õ�ip��ӡ����*/
//���� 6 : ��ϰ-�жϱ������ж��ٿ��õ�ip��ַ
public class IpAndPortPracetice {
	/*Ϊ�����Ч�ʣ�ʹ�ö��̷߳�ʽͬʱping�� �����������255���̣߳��ֻ���Ϊ����˿�̫ӵ�����ᱻ�ж�Ϊ�޷�pingͨ��
	���Ա���ʹ��java�Դ��̳߳أ��̳߳ص�������������̫��������15���̡߳� 
	
	�ȴ����е��߳̽������ӡ��pingͨ�˵�ip��ַ��*/
	public static void main(String[] args) throws IOException, UnknownHostException{
		InetAddress host=InetAddress.getLocalHost();
		String ip =host.getHostAddress();
		String ipRange=ip.substring(0,ip.lastIndexOf('.'));//����ַ����е����һ����
		System.out.println("����ip��ַ��"+ip);
		System.out.println("�����ǣ�"+ipRange);

		//��ʼ�����ip�������������ip������ת�����̰߳�ȫ��
		List<String> ips=Collections.synchronizedList(new ArrayList<>());
		//��ʼ���̳߳�
		ThreadPoolExecutor threadPool =new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, 
			new LinkedBlockingDeque<Runnable>());
		AtomicInteger number=new AtomicInteger();
		for(int i=0;i<255;i++){
			String testIP=ipRange+"."+(i+1);//ƴ�ɵ�ַ
			threadPool.execute(new Runnable(){
				@Override
				public void run(){
					boolean reachable=isReachable(testIP);
					if(reachable)
						System.out.println("�ҵ������ӵ�ip��ַ��" + testIP);
						ips.add(testIP);
					
					synchronized(number){
							System.out.println("�Ѿ���ɣ�"+number.incrementAndGet()+"��ip����");
					}
				}
			});
		}


	}

	private static boolean isReachable(String ip){
		try {
			boolean reachable=false;
			// Windows�µ���ϵͳ����:Process proc =Runtime.getRuntime().exec(����);
			Process p=Runtime.getRuntime().exec("ping "+ip);
			BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line =null;
			StringBuilder sb=new StringBuilder();
			//��ping���ص���Ϣ���ո�ʽ���뵽StringBuilder��
			while((line=br.readLine())!=null){
				if(line.length()!=0){
					sb.append(line+"\r\n");
				}
			}
		//����time���ֵ�ʱ�򣬾ͱ�ʾ��ͨ��
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
