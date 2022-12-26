package Model;

public class Comment {
	private int id;
	private String content;
	private int id_match;
	private int id_user;
	private String date;
	private String fullName;
	private String img;
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	
	public Comment(int id, String content, int id_match, int id_user, String date, String fullName, String img) {
		super();
		this.id = id;
		this.content = content;
		this.id_match = id_match;
		this.id_user = id_user;
		this.date = date;
		this.fullName = fullName;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId_match() {
		return id_match;
	}

	public void setId_match(int id_match) {
		this.id_match = id_match;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", id_match=" + id_match + ", id_user=" + id_user
				+ ", date=" + date + ", fullName=" + fullName + ", img=" + img + "]";
	}

	

	
	
}
