package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//����ʹ��JDBC
public class HelloJDBC {
	/*
	 * ���� 1 : Ϊ��Ŀ����mysql-jdbc��jar�� ����
	 * ����MySQL���ݿ���Ҫ�õ����������࣬��Щ���������࣬����ѹ����һ������Jar���ļ��
	 * Ϊ�˴����ܹ�ʹ�õ��������࣬��ҪΪ��Ŀ����mysql��ר��Jar����
	 * �ð�mysql-connector-java-5.0.8-bin.jar�������ұ�����
	 * ͨ���������Ŀ�õ���jar��ͳһ������Ŀ��libĿ¼�£��ڱ����ͻ���� E:\project\j2se\lib ���λ��
	 * Ȼ����eclipse�е������jar��
	 * 
	 * �������裺 �Ҽ�project->property->java build path->libaries->add external jars
	 */
	public static void main(String[] args) {
		/*
		 * ���� 2 : ��ʼ������ ͨ��Class.forName("com.mysql.jdbc.Driver");
		 * ��ʼ��������com.mysql.jdbc.Driver ���� mysql-connector-java-5.0.8-bin.jar��
		 * ��������˵�һ������ĵ������ͻ��׳�ClassNotFoundException
		 * 
		 * Class.forName�ǰ��������ص�JVM�У����ص�ʱ�򣬾ͻ�ִ�����еľ�̬��ʼ���飬��������ĳ�ʼ������ع�����
		 */
		Connection c=null;
		Statement s=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���ݿ���������سɹ�");

			/*
			 * ���� 3 : ���������ݿ������ ���������ݿ��Connection���� ������Ҫ�ṩ�� ���ݿ������ڵ�ip:127.0.0.1
			 * (����) ���ݿ�Ķ˿ںţ� 3306 ��mysqlר�ö˿ںţ� ���ݿ����� how2java ���뷽ʽ UTF-8 �˺� root
			 * ���� admin
			 * 
			 * ע�� ��һ��Ҫ�ɹ�ִ�У����뽨����mysql�������ݿ�how2java�Ļ����ϣ�
			 * ���û�У�����������ݿ�鿴��ν������ݿ�Ĵ�����
			 */

			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
					"root", "123456");
			System.out.println("���ӳɹ�����ȡ���Ӷ���" + c);

			/*
			 * ���� 4 : ����Statement ���� Statement������ִ��SQL���ģ��������ӣ�ɾ��
			 */

			// ע�⣺ʹ�õ��� java.sql.Statement
			// ��Ҫ��С��ʹ�õ��� com.mysql.jdbc.Statement;
			s = c.createStatement();
			System.out.println("��ȡ Statement����" + s);

			/*
			 * ���� 5 : ִ��SQL��� ���� s.executeִ��sql��� ִ�гɹ�����mysql-front���в鿴����ȷ����ɹ�
			 * 
			 * ִ��SQL���֮ǰҪȷ�����ݿ�how2java���б�hero�Ĵ��ڣ����û�У���Ҫ���ȴ�����
			 */

			// ׼��sql���
			// ע�⣺ �ַ���Ҫ�õ�����'
			//String sql = "insert into hero values(null,'���',313.0f,50)";
			String sql = "insert into hero values(null," + "'���'" + "," + 313.0f + "," + 50 + ");";
			s.execute(sql);
			System.out.println("ִ�в������ɹ�");

		} catch (ClassNotFoundException e) {// ��Ӧ����������
			e.printStackTrace();
		} catch (SQLException e) {// ��Ӧ����mysql���ݿ�
			e.printStackTrace();
		}
		// System.out.println("���ӳɹ�����ȡ���Ӷ���"+c);//���Connection��try���������Ļ�����������д����Ϊc��try��������ܻ���Ϊ�����쳣����ȡʧ��
		
		finally{
			/*���� 6 : �ر�����
			���ݿ��������������Դ����ز������������ɹر����ݿ�ĺ�ϰ��
			�ȹر�Statement
			��ر�Connection*/
			if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            // ��ر�Connection
            if (c != null)
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
		}/*
		���� 7 : ʹ��try-with-resource�ķ�ʽ�Զ��ر�����
		���������һ���Ĺر����ӵķ�ʽ���鷳�����Բο��ر��� �ķ�ʽ��ʹ��try-with-resource�ķ�ʽ�Զ��ر����ӣ���ΪConnection��Statement��ʵ����AutoClosable�ӿ�*/
		
		
	}

}
