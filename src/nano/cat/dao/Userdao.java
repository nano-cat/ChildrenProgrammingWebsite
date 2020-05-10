package nano.cat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nano.cat.bean.User;

public class Userdao {
	String pwd =null;
	Connection connection = null;
	Statement statement = null;
	PreparedStatement st =null;
	ResultSet rs = null;
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/jsp?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	
	//查询给定用户的信息(密码)
	public String findUserName(String username) {
		
		try {
			// 注册 JDBC 驱动器
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(JDBC_URL,"tomcat","javaweb");
			// 执行 SQL 查询
			statement = connection.createStatement();
			String sql = "SELECT UserName,Password FROM userinfo WHERE UserName='"+ username +"'"; 
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			if(rs == null) {
				return null;
			}
			if(rs.next()) {
				pwd = rs.getString("Password");
			}else {
				pwd = null;
			}
				
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
		return pwd;
	}
	
	//数据库中增加给定用户
	public boolean Regist(String username, String password) {
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(JDBC_URL,"tomcat","javaweb");

			String sql = "INSERT INTO userinfo (UserName, Password)"+ "VALUES (?,?)"; 
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, username);
            st.setString(2, password);
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
	
	//获取所有的用户信息
	public List<User> getAllUser(){
		List<User> list = new ArrayList<User>();
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(JDBC_URL,"tomcat","javaweb");

			statement = connection.createStatement();
			String sql = "SELECT * FROM userinfo"; 
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				int userid = rs.getInt("UserId");
				String user = rs.getString("UserName");
				String password = rs.getString("Password");
				User n = new User(userid, user, password);
				list.add(n);
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
	
	//更改给定用户的密码
	public Boolean changePassword(String username, String password) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(JDBC_URL,"tomcat","javaweb");

			String sql = "UPDATE userinfo SET Password=? WHERE UserName=?"; 
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, password);
			st.setString(2, username);
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
	
	//删除数据库中给定的用户
	public Boolean deleteUser(String username) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(JDBC_URL,"tomcat","javaweb");
			
			String sql = "DELETE FROM userinfo WHERE UserName=?"; 
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, username);
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
}
