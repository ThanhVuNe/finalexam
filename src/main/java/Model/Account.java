package Model;

public class Account {
	private int id;
	private String email;
	private String password;
	private int role;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int id, String email, String password, int role) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
