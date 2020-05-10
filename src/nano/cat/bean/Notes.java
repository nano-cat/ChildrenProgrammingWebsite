package nano.cat.bean;

public class Notes {
	private int NoteId;			//笔记ID
	private String UserName;	//笔记所属用户
	private String Title;		//笔记标题
	private String Content;		//笔记内容
	private String CreateDate;	//笔记创建时间
	
	public int getNoteId() {
		return NoteId;
	}
	public void setNoteId(int noteId) {
		NoteId = noteId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
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
	public String getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(String createDate) {
		CreateDate = createDate;
	}
	
	public Notes (int noteid, String username, String title, String content, String createdate) {
		super();
		this.NoteId = noteid;
		this.UserName = username;
		this.Title = title;
		this.Content = content;
		this.CreateDate = createdate;
	}
}
