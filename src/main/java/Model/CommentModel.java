package Model;

public class CommentModel {
	private int id;
	private String content;
	private int id_match;
	private int id_user;
	private String date;
	public CommentModel() {
		// TODO Auto-generated constructor stub
	}
	public CommentModel(int id, String content, int id_match, int id_user, String date) {
		super();
		this.id = id;
		this.content = content;
		this.id_match = id_match;
		this.id_user = id_user;
		this.date = date;
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
	@Override
	public String toString() {
		return "CommentModel [id=" + id + ", content=" + content + ", id_match=" + id_match + ", id_user=" + id_user
				+ ", date=" + date + "]";
	}
	
}
