package pers.oyxx.someDemo.WebProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Socket-��ϰ-����˺Ϳͻ��˻���
/*ǰ�沿�ֵ�ѧϰЧ���Ƿ���˽������ݣ��ͻ��˷������ݡ�

����Ӧ�ĸĶ���ʹ�÷����Ҳ�ܷ������ݣ��ͻ���Ҳ�ܽ������ݣ����ҿ���һֱ������ȥ*/
public class SocketPractice1S {
	// ��ʾ��ǰʱ��
	public static String now() {
		return (new SimpleDateFormat("yy/MM/dd HH:mm:ss").format(new Date()));
	}

	public static void main(String[] args) {
		// �������߳�-���ڽ�����Ϣ
		Thread t1 = new Thread() {
			public void run() {
				try (ServerSocket ss = new ServerSocket(8889);// ������Ϣ��Socket
				) {
					while (true) {

						// �����Ϣ
						Socket clientSocket = ss.accept();
						InputStream is = clientSocket.getInputStream();
						DataInputStream dis = new DataInputStream(is);
						String msg = dis.readUTF();
						// �����Ϣ
						System.out.println(now() + clientSocket + ":");
						System.out.println(msg);
						// ��������ر�������
						// dis.close();
					}

				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		};
		// �ͻ����߳�-���ڷ�����Ϣ
		Thread t2 = new Thread() {
			public void run() {
				// �ȵȶ�������
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {//���ܰ�thisSocket������try-with-source���棬����ֻ�ܷ���һ�Σ��ڶ��λ���ʾSocket closed
					while (true) {
						// ���Ҫ���͵���Ϣ
						Socket thisSocket = new Socket("127.0.0.1", 8890);// ������Ϣ��Socket
						OutputStream os = thisSocket.getOutputStream();
						DataOutputStream dos = new DataOutputStream(os);
						Scanner scanner = new Scanner(System.in);
						String msg = scanner.nextLine();
						// ������Ϣ
						dos.writeUTF(msg);
						// ���ͽ����ر�������
						dos.close();
					}

				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		};

		t1.start();
		t2.start();

	}
}
