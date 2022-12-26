package Model;

public class TeamDetail {
	private int id;
	private int id_season;
	private int id_team;
	public TeamDetail() {
		// TODO Auto-generated constructor stub
	}
	public TeamDetail(int id, int id_season, int id_team) {
		super();
		this.id = id;
		this.id_season = id_season;
		this.id_team = id_team;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_season() {
		return id_season;
	}
	public void setId_season(int id_season) {
		this.id_season = id_season;
	}
	public int getId_team() {
		return id_team;
	}
	public void setId_team(int id_team) {
		this.id_team = id_team;
	}
	@Override
	public String toString() {
		return "TeamDetail [id=" + id + ", id_season=" + id_season + ", id_team=" + id_team + "]";
	}
	
	
}
