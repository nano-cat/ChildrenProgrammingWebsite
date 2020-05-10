package nano.cat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nano.cat.bean.Notes;

public class notesdao {
	Connection connection = null;
	Statement statement = null;
	PreparedStatement st =null;
	ResultSet rs = null;	//数据库结果集
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/jsp?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	
	//增加指定用户笔记
	public boolean setNotes (String username,String title, String content) {
		
		try {
			// 注册 JDBC 驱动器
			Class.forName(JDBC_DRIVER);
			// 打开一个数据库连接
			connection = DriverManager.getConnection(JDBC_URL,"tomcat","javaweb");
			String sql = "INSERT INTO usernote ( UserName, Title, Content, CreateDate)"+ "VALUES (?,?,?,NOW())"; 
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, username);
            st.setString(2, title);
            st.setString(3, content);
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
	
	//获取指定用户的笔记
	public List<Notes> getNotes(String username) {
		List<Notes> list = new ArrayList<Notes>();
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(JDBC_URL,"tomcat","javaweb");

			statement = connection.createStatement();
			String sql = "SELECT * FROM usernote WHERE UserName='"+ username +"'"; 
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				int noteid = rs.getInt("NoteId");
				String user = rs.getString("UserName");
				String title = rs.getString("Title");
				String content = rs.getString("Content");
				String createdate = rs.getString("CreateDate");
				Notes n = new Notes(noteid, user, title, content,createdate);
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
	
	//获取所有的笔记
	public List<Notes> getAllNotes(){
		List<Notes> list = new ArrayList<Notes>();
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(JDBC_URL,"tomcat","javaweb");

			statement = connection.createStatement();
			String sql = "SELECT * FROM usernote"; 
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				int noteid = rs.getInt("NoteId");
				String user = rs.getString("UserName");
				String title = rs.getString("Title");
				String content = rs.getString("Content");
				String createdate = rs.getString("CreateDate");
				Notes n = new Notes(noteid, user, title, content,createdate);
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
	
	//删除指定笔记编号的用户笔记
	public Boolean deleteNotes(String noteid) {
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(JDBC_URL,"tomcat","javaweb");

			String sql = "DELETE FROM usernote WHERE NoteId=?"; 
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, noteid);
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
