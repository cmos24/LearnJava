package pers.oyxx.someDemo.WebProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

//IP�Ͷ˿�
public class IpAndPort {
	/*
	 * ���� 1 : IP��ַ ��������ÿ̨�������������һ����IP��ַ�� 32λ��4���ֽڣ����õ��ʮ���Ƶĸ�ʽ��ʾ�����磺192.168.1.100
	 * 127.0.0.1 �ǹ̶�ip��ַ������ǰ��������൱������������ "this"
	 * 
	 */

	/*
	 * ���� 2 : �˿� ��̨������������ӣ�����һ̨��������һ̨�ͻ��ˡ� �������Ϳͻ���֮���ͨ��ͨ���˿ڽ��С���ͼ��
	 */

	/* ���� 3 : ��ȡ����IP��ַ */
	public static void main(String[] args) throws UnknownHostException, IOException {
		InetAddress host = InetAddress.getLocalHost();
		String ip = host.getHostAddress();
		System.out.println("����ip��ַ��" + ip);

		/*
		 * ���� 4 : ping���� ʹ��ping�ж�һ����ַ�Ƿ��ܹ�����
		 * ping����java��api����windows�е�һ��С���ߣ������ж�һ����ַ����Ӧʱ��
		 */

		/*
		 * ���� 5 : ʹ��java ִ��ping���� ���� Runtime.getRuntime().exec()
		 * ��������һ��windows��exe����
		 */
		Process p = Runtime.getRuntime().exec("ping " + "www.baidu.com");//"ping"����Ŀո�һ��Ҫ��
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = null;
		StringBuilder sb = new StringBuilder();// ���̰߳�ȫ��StringBuffered�������ݣ�����char[]װ��ԭ���ǲ�֪���������ݵĳ��ȣ����ܳ�ʼ��
		while ((line = br.readLine()) != null) {
			if (line.length() != 0) {
				sb.append(line + "\r\n");//���ַ������мӵ�StringBufferedĩβ�����һ���Լӽ�ȥ�����п��Ա���ԭ�����еĸ�ʽ
			}
		}
		System.out.println("����ָ��ص���Ϣ�ǣ�");
		System.out.println(sb.toString());

	}

}
