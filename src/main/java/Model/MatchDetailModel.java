package Model;

public class MatchDetailModel {
	private int id;
	private int id_team;
	private int id_match;
	private int status;
	private int score;
	public MatchDetailModel() {
		// TODO Auto-generated constructor stub
	}
	public MatchDetailModel(int id, int id_team, int id_match, int status, int score) {
		super();
		this.id = id;
		this.id_team = id_team;
		this.id_match = id_match;
		this.status = status;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_team() {
		return id_team;
	}
	public void setId_team(int id_team) {
		this.id_team = id_team;
	}
	public int getId_match() {
		return id_match;
	}
	public void setId_match(int id_match) {
		this.id_match = id_match;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "MatchDetailModel [id=" + id + ", id_team=" + id_team + ", id_match=" + id_match + ", status=" + status
				+ ", score=" + score + "]";
	}
	
	
}
