package models;

public class Discount {

	private String code;
	private int discount;
	private int required_spending;
	private boolean used;

	public enum discount_type {
		total, percent
	}

	private discount_type type;

	public Discount() {
		super();
	}

	public Discount(int id, String code, int discount, int required_spending, discount_type type, boolean used) {
		super();

		this.code = code;
		this.discount = discount;
		this.required_spending = required_spending;
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getRequired_spending() {
		return required_spending;
	}

	public void setRequired_spending(int required_spending) {
		this.required_spending = required_spending;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public discount_type getType() {
		return type;
	}

	public void setType(discount_type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Discount [code=" + code + ", discount=" + discount + ", required_spending=" + required_spending
				+ ", used=" + used + ", type=" + type + "]";
	}
}