package Model;

public class Season {
	private int id;
	private String yearS;
	private String yearE;
	public Season() {
		// TODO Auto-generated constructor stub
	}
	public Season(int id, String yearS, String yearE) {
		super();
		this.id = id;
		this.yearS = yearS;
		this.yearE = yearE;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYearS() {
		return yearS;
	}
	public void setYearS(String yearS) {
		this.yearS = yearS;
	}
	public String getYearE() {
		return yearE;
	}
	public void setYearE(String yearE) {
		this.yearE = yearE;
	}
	@Override
	public String toString() {
		return "Season [id=" + id + ", yearS=" + yearS + ", yearE=" + yearE + "]";
	}
	
}
