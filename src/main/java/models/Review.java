package models;

public class Review {
	private String reviewer;
	private int stars;
	private String details;
	private int productId;

	public Review() {
		super();
	}

	public Review(String reviewer, int stars, String details, int productId) {
		super();
		this.reviewer = reviewer;
		this.stars = stars;
		this.details = details;
		this.productId = productId;
	}

	public String getReviewer() {
		return reviewer;
	}

	public int getStars() {
		return stars;
	}

	public String getDetails() {
		return details;
	}
	
	public int getProductId() {
		return productId;
	}
}
