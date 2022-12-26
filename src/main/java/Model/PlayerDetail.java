package Model;

public class PlayerDetail {
	private int id_team;
	private String name;
	private int minute;
	
	public PlayerDetail() {
		// TODO Auto-generated constructor stub
	}

	public PlayerDetail(int id_team, String name, int minute) {
		super();
		this.id_team = id_team;
		this.name = name;
		this.minute = minute;
	}

	public int getId_team() {
		return id_team;
	}

	public void setId_team(int id_team) {
		this.id_team = id_team;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinutes(int minute) {
		this.minute = minute;
	}

	@Override
	public String toString() {
		return "PlayerDetail [id_team=" + id_team + ", name=" + name + ", minute=" + minute + "]";
	}
	
}
