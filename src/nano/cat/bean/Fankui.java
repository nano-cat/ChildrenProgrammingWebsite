package nano.cat.bean;

public class Fankui {
	private int LwId;			//用户留言反馈ID
	private String UserName;	//反馈者用户名
	private String Email;		//留言反馈邮箱
	private String Title;		//留言标题
	private String Content;		//留言内容
	private String SendTime;	//留言发送时间
	
	public int getLwId() {
		return LwId;
	}
	public void setLwId(int lwId) {
		LwId = lwId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getSendTime() {
		return SendTime;
	}
	public void setSendTime(String sendTime) {
		SendTime = sendTime;
	}

	public Fankui (int lwid, String username, String email, String title, String content, String sendtime) {
		super();
		this.LwId = lwid;
		this.UserName = username;
		this.Email = email;
		this.Title = title;
		this.Content = content;
		this.SendTime = sendtime;
	}
}
