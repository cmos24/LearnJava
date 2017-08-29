package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionPractice {

	public static void main(String[] args) {
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "123456");
                Statement st4Query = c.createStatement();
                Statement st4Delete = c.createStatement();
                Scanner s = new Scanner(System.in);) {
 
            //���Զ��ύ�ر�
            c.setAutoCommit(false);
            //���ǰ10��
            ResultSet rs =st4Query.executeQuery("select id from Hero order by id asc limit 0,10 ");
            while(rs.next()){
                int id = rs.getInt(1);
                System.out.println("��ͼɾ��id="+id+" ������");
                st4Delete.execute("delete from Hero where id = " +id);
            }
             
            //�Ƿ�ɾ����10��
            while(true){
                System.out.println("�Ƿ�Ҫɾ������(Y/N)");
                 
                String str = s.next();
                if ("Y".equals(str)) {
                    //����������Y�����ύɾ������
                    c.commit();
                    System.out.println("�ύɾ��");
                    break;
                } else if ("N".equals(str)) {
                    System.out.println("����ɾ��");
                    break;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
