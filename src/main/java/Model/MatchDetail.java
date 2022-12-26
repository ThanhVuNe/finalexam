package Model;

public class MatchDetail {
	private int id_team;
	private int id_match;
	private int status;
	private int score;
	private String name;
	private String logo;
	private String date;
	private String description;
	private int card;
	public MatchDetail() {
		// TODO Auto-generated constructor stub
	}
	public MatchDetail(int id_team, int id_match, int status, int score, String name, String logo, String date,
			String description, int card) {
		this.id_team = id_team;
		this.id_match = id_match;
		this.status = status;
		this.score = score;
		this.name = name;
		this.logo = logo;
		this.date = date;
		this.description = description;
		this.card = card;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCard() {
		return card;
	}
	public void setCard(int card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "MatchDetail [id_team=" + id_team + ", id_match=" + id_match + ", status=" + status + ", score=" + score
				+ ", name=" + name + ", logo=" + logo + ", date=" + date + ", description=" + description + ", card="
				+ card + "]";
	}
	
}
