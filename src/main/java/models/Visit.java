package models;

public class Visit {
	public enum Status {
		VIEWED,
		IN_CART,
		PURCHASED,
	}
	
	private String ipAddress;
	private int productId;
	private Status status;

	public Visit() {
		super();
	}

	public Visit(String ipAddress, int productId, Status status) {
		super();
		this.ipAddress = ipAddress;
		this.productId = productId;
		this.status = status;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public int getProductId() {
		return productId;
	}

	public Status getStatus() {
		return status;
	}
}
