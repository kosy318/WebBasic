import java.util.Date;

// DTO

public class Board {
	
	private int no;
	private String title;
	private String content;
	private String userid;
	private Date createdAt;
	
	public Board() {}
	
	public Board(int no, String title, String content, String userid, Date createdAt) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.userid = userid;
		this.createdAt = createdAt;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", content=" + content + ", userid=" + userid + ", createdAt="
				+ createdAt + "]";
	}
	
}
