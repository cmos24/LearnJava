package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//初次使用JDBC
public class HelloJDBC {
	/*
	 * 步骤 1 : 为项目导入mysql-jdbc的jar包 提问
	 * 访问MySQL数据库需要用到第三方的类，这些第三方的类，都被压缩在一个叫做Jar的文件里。
	 * 为了代码能够使用第三方的类，需要为项目导入mysql的专用Jar包。
	 * 该包mysql-connector-java-5.0.8-bin.jar可以在右边下载
	 * 通常都会把项目用到的jar包统一放在项目的lib目录下，在本例就会放在 E:\project\j2se\lib 这个位置
	 * 然后在eclipse中导入这个jar包
	 * 
	 * 导包步骤： 右键project->property->java build path->libaries->add external jars
	 */
	public static void main(String[] args) {
		/*
		 * 步骤 2 : 初始化驱动 通过Class.forName("com.mysql.jdbc.Driver");
		 * 初始化驱动类com.mysql.jdbc.Driver 就在 mysql-connector-java-5.0.8-bin.jar中
		 * 如果忘记了第一个步骤的导包，就会抛出ClassNotFoundException
		 * 
		 * Class.forName是把这个类加载到JVM中，加载的时候，就会执行其中的静态初始化块，完成驱动的初始化的相关工作。
		 */
		Connection c=null;
		Statement s=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库驱动类加载成功");

			/*
			 * 步骤 3 : 建立与数据库的连接 建立与数据库的Connection连接 这里需要提供： 数据库所处于的ip:127.0.0.1
			 * (本机) 数据库的端口号： 3306 （mysql专用端口号） 数据库名称 how2java 编码方式 UTF-8 账号 root
			 * 密码 admin
			 * 
			 * 注： 这一步要成功执行，必须建立在mysql中有数据库how2java的基础上，
			 * 如果没有，点击创建数据库查看如何进行数据库的创建。
			 */

			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
					"root", "123456");
			System.out.println("连接成功，获取连接对象" + c);

			/*
			 * 步骤 4 : 创建Statement 提问 Statement是用于执行SQL语句的，比如增加，删除
			 */

			// 注意：使用的是 java.sql.Statement
			// 不要不小心使用到： com.mysql.jdbc.Statement;
			s = c.createStatement();
			System.out.println("获取 Statement对象" + s);

			/*
			 * 步骤 5 : 执行SQL语句 提问 s.execute执行sql语句 执行成功后，用mysql-front进行查看，明确插入成功
			 * 
			 * 执行SQL语句之前要确保数据库how2java中有表hero的存在，如果没有，需要事先创建表
			 */

			// 准备sql语句
			// 注意： 字符串要用单引号'
			//String sql = "insert into hero values(null,'光辉',313.0f,50)";
			String sql = "insert into hero values(null," + "'光辉'" + "," + 313.0f + "," + 50 + ");";
			s.execute(sql);
			System.out.println("执行插入语句成功");

		} catch (ClassNotFoundException e) {// 对应加载驱动类
			e.printStackTrace();
		} catch (SQLException e) {// 对应连接mysql数据库
			e.printStackTrace();
		}
		// System.out.println("连接成功，获取连接对象"+c);//如果Connection在try块中声明的话不能在这里写，因为c在try块里面可能会因为产生异常而获取失败
		
		finally{
			/*步骤 6 : 关闭连接
			数据库的连接是有限资源，相关操作结束后，养成关闭数据库的好习惯
			先关闭Statement
			后关闭Connection*/
			if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            // 后关闭Connection
            if (c != null)
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
		}/*
		步骤 7 : 使用try-with-resource的方式自动关闭连接
		如果觉得上一步的关闭连接的方式很麻烦，可以参考关闭流 的方式，使用try-with-resource的方式自动关闭连接，因为Connection和Statement都实现了AutoClosable接口*/
		
		
	}

}
