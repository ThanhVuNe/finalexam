package Model;

public class MatchModel {
	private int id;
	private String date;
	private int id_season;
	private int card;
	public MatchModel() {
		// TODO Auto-generated constructor stub
	}
	public MatchModel(int id, String date, int id_season, int card) {
		super();
		this.id = id;
		this.date = date;
		this.id_season = id_season;
		this.card = card;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId_season() {
		return id_season;
	}
	public void setId_season(int id_season) {
		this.id_season = id_season;
	}
	public int getCard() {
		return card;
	}
	public void setCard(int card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "MatchModel [id=" + id + ", date=" + date + ", id_season=" + id_season + ", card=" + card + "]";
	}
	
}
