package nano.cat.bean;

public class User {
	private int UserId;			//用户ID
	private String UserName;	//用户名
	private String Password;	//用户密码
	
	
	public int getUserId() {
		return UserId;
	}


	public void setUserId(int userId) {
		UserId = userId;
	}


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public User (int userid, String username, String password) {
		super();
		this.UserId = userid;
		this.UserName = username;
		this.Password = password;
	}

}
