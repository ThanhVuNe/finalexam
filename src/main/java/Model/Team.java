package Model;


public class Team {
	private int id;
	private String name;
	private String arena;
	private String logo;
	private int id_season;
	private String img_arena;
	private String description;
	public Team() {
		// TODO Auto-generated constructor stub
	}
	
	public Team(int id, String name, String arena, String logo, String img_arena, String description) {
		super();
		this.id = id;
		this.name = name;
		this.arena = arena;
		this.logo = logo;
		this.img_arena = img_arena;
		this.description = description;
	}

	public Team(int id, String name, String arena, String logo, int id_season, String img_arena, String description) {
		super();
		this.id = id;
		this.name = name;
		this.arena = arena;
		this.logo = logo;
		this.id_season = id_season;
		this.img_arena = img_arena;
		this.description = description;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArena() {
		return arena;
	}
	public void setArena(String arena) {
		this.arena = arena;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public int getId_season() {
		return id_season;
	}
	public void setId_season(int id_season) {
		this.id_season = id_season;
	}
	
	public String getImg_arena() {
		return img_arena;
	}

	public void setImg_arena(String img_arena) {
		this.img_arena = img_arena;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", arena=" + arena + ", logo=" + logo + ", id_season=" + id_season
				+ ", img_arena=" + img_arena + ", description=" + description + "]";
	}

	
}
