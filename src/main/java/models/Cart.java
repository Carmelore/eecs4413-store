package models;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.annotation.Scope;

import models.Discount.discount_type;

@Scope
public class Cart {
	private Map<Product, Integer> items;
	private Map<Integer, Discount> discounts;
	private double appliedDiscounts;
	private double percentageDiscount;
	private double subtotal;
	private double totalPrice;

	public Cart() {
		this.items = new HashMap<>();
	}

	public void addItem(Product product, int quantity) {
		if (product == null || quantity <= 0) {
			throw new IllegalArgumentException("Invalid product or quantity");
		}

		if (items.containsKey(product)) {
			quantity += items.get(product);
		}

		items.put(product, quantity);

		updateSubtotal();
	}

	public void addDiscount(Discount discount) {
		if (discount == null || discount.getUsed()) {
			throw new IllegalArgumentException("Invalid discount or code has been used already");
		}

		if (items.containsKey(discount.getId())) {
			throw new IllegalArgumentException("Discount already applied");
		}

		discounts.put(discount.getId(), discount);

		updateDiscounts();
	}

	public void removeItem(Product product) {
		if (product == null) {
			throw new IllegalArgumentException("Invalid product");
		}

		items.remove(product);
	}

	public void updateQuantity(Product product, int quantity) {
		if (product == null || quantity <= 0) {
			throw new IllegalArgumentException("Invalid product or quantity");
		}

		items.put(product, quantity);
	}

	public Map<Product, Integer> getItems() {
		return Collections.unmodifiableMap(items);
	}

	public int getTotalQuantity() {
		return items.values().stream().mapToInt(Integer::intValue).sum();
	}

	private void updateSubtotal() {
		subtotal = items.entrySet().stream().mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue()).sum();
	}

	public double getSubtotal() {
		return subtotal;
	}

	private void updateDiscounts() {
		for (Entry<Integer, Discount> discount : discounts.entrySet()) {
			if (discount.getValue().getType() == discount_type.total
					&& subtotal > discount.getValue().getRequired_spending()) {
				appliedDiscounts += discount.getValue().getDiscount();
			} else {
				percentageDiscount += discount.getValue().getDiscount();
			}
			discount.getValue().setUsed(true);
		}
	}

	public double getTotalPrice() {
		subtotal -= appliedDiscounts;
		subtotal = subtotal - (subtotal * (percentageDiscount / 100));
		return totalPrice;
	}
}
