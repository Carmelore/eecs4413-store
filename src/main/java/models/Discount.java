package models;

public class Discount {
	private int id;
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
		this.id = id;
		this.code = code;
		this.discount = discount;
		this.required_spending = required_spending;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}
	
	public boolean getUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public int getDiscount() {
		return discount;
	}

	public int getRequired_spending() {
		return required_spending;
	}

	public void setRequired_spending(int required_spending) {
		this.required_spending = required_spending;
	}

	public discount_type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Discount [id=" + id + ", code=" + code + ", discount=" + discount + ", required_spending="
				+ required_spending + ", used=" + used + ", type=" + type + "]";
	}

}
