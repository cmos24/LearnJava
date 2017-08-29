package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//����
public class Transaction {
	/*���� 1 : ��ʹ����������
	û�������ǰ����
	����ҵ������ǣ���Ѫ����Ѫ����һ��
	������Ӣ�۵�Ѫ������
	����Ѫ��SQL
	��С��д��д���� updata(����update)
	��ô�������Ѫ�������ˣ����������Ĳ���*/
	public static void main(String[] args) {
		/*���� 2 : ʹ������
		�������еĶ��������Ҫô���ɹ���Ҫô��ʧ��
		ͨ�� c.setAutoCommit(false);�ر��Զ��ύ
		ʹ�� c.commit();�����ֶ��ύ
		��22��-35��֮������ݿ�������ʹ���ͬһ�������У�Ҫô���ɹ���Ҫô��ʧ��
		���ԣ���Ȼ��һ��SQL����ǿ���ִ�еģ����ǵڶ���SQL����д���������������SQL��䶼û�б��ύ�� ��������SQL��䶼����ȷ�ġ�*/
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "123456");
            Statement s = c.createStatement();) {
        	// �������ǰ����
            // �������еĶ��������Ҫô���ɹ���Ҫô��ʧ��
        	
        	c.setAutoCommit(false);//�ر��Զ��ύ
        	
        	//��Ѫ��SQL
        	String sql1="update hero set hp=hp+1 where id=317";
        	s.execute(sql1);
        	
        	//��Ѫ��SQL
        	//��С��д��� updata
        	String sql2="update hero set hp=hp-1 where id=317";
        	s.execute(sql2);
        	
        	//�ֶ��ύ
        	c.commit();
        	
        } catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
