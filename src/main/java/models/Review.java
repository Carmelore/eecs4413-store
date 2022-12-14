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
	
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Review [reviewer=" + reviewer + ", stars=" + stars + ", details=" + details + ", productId=" + productId
				+ "]";
	}
}
