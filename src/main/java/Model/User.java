package Model;

public class User {
	private int id;
	private String name;
	private int age;
	private String img;
	private int id_account;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, int age, String img, int id_account) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.img = img;
		this.id_account = id_account;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getId_account() {
		return id_account;
	}

	public void setId_account(int id_account) {
		this.id_account = id_account;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", img=" + img + ", id_account=" + id_account
				+ "]";
	}
	
}
