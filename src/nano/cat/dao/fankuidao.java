package nano.cat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nano.cat.bean.Fankui;

public class fankuidao {
	String fk = null;
	Connection connection = null;
	Statement statement = null;
	PreparedStatement st =null;
	ResultSet rs = null;	//数据查询结果集
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/jsp?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	
	//写入反馈与建议信息
	public boolean setFankui (String username, String email, String title, String content) {
		
		try {
			// 注册 JDBC 驱动器
			Class.forName(JDBC_DRIVER);
			// 打开一个数据库连接
			connection = DriverManager.getConnection(JDBC_URL,"tomcat","javaweb");
			String sql = "INSERT INTO leaveword ( UserName, Email, Title, Content, SendTime)"+ "VALUES (?,?,?,?,NOW())"; 
			PreparedStatement st = connection.prepareStatement(sql);	//sql语句准备
			st.setString(1, username);
			st.setString(2, email);
            st.setString(3, title);
            st.setString(4, content);
			st.executeUpdate(); //更新
			
		}catch (SQLException se) {
			se.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(st!=null)st.close();
				if(connection!=null)connection.close();
			}catch(SQLException e) {	}
		}
		return true;
	}
	
	//获取所有的反馈建议信息
	public List<Fankui> getAllFankui() {
		List<Fankui> list = new ArrayList<Fankui>();	//创建反馈的列表对象
		
		try {
			// 注册 JDBC 驱动器
			Class.forName(JDBC_DRIVER);
			
			// 打开一个数据库连接
			connection = DriverManager.getConnection(JDBC_URL,"tomcat","javaweb");

			statement = connection.createStatement();
			String sql = "SELECT * FROM leaveword"; 
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();	//将查询数据赋予结果集
			
			while(rs.next()) {
				int lwid = rs.getInt("LwId");
				String user = rs.getString("UserName");
				String email = rs.getString("Email");
				String title = rs.getString("Title");
				String content = rs.getString("Content");
				String sendtime = rs.getString("SendTime");
				Fankui n = new Fankui(lwid, user, email,title, content, sendtime);	//创建反馈对象
				list.add(n);	//加入ArrayList
			}
			return list;
			
		}catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(st!=null)st.close();
				if(connection!=null)connection.close();
			}catch(SQLException e) {	}
		}
		return list;
	}
}
