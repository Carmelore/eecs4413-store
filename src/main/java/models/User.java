package models;

public class User {
	private int id;
	private String name;
	private String username;
	private String password;
	private boolean admin;
	
	public User() {
		super();
	}
	
	public User(int id, String name, String username, String password, boolean admin) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", admin="
				+ admin + "]";
	}
}