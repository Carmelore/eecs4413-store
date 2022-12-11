package models;

public class User {
	private int id;
	private String name;
	private String username;
	private String password;
	private String shipping_address;
	private String billing_address;
	private boolean admin;
	
	public User() {
		super();
	}
	
	public User(int id, String name, String username, String password, String shipping_address, String billing_address, boolean admin) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.shipping_address = shipping_address;
		this.billing_address = billing_address;
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
	
	public String getShipping_address() {
		return shipping_address;
	}
	
	public String getBilling_address() {
		return billing_address;
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
	
	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}
	
	public void setBilling_address(String billing_address) {
		this.billing_address = billing_address;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", shipping_address=" + shipping_address + ", billing_address=" + billing_address + ", admin=" + admin
				+ "]";
	}
}