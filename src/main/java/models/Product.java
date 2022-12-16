package models;

public class Product {
	private int id;
	private String name;
	private String description;
	private String type; 
	private String brand;
	private int quantity;
	private double price;
	private int amount;
	
	public Product() {
		super();
	}
	
	public Product(int id, String name, String description, String type, String brand, int quantity, double price, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
		this.brand = brand;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
    public String toString() {
        return String.format("Product [id=%s, name=%s, description=%s, type=%s, "
        		+ "brand=%s, quantity=%s, price=%s, amount=%s]", id, name, description, type, brand, quantity, price, amount);
    }

}
