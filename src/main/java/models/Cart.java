package models;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;

@Scope
public class Cart {
	private Map<Product, Integer> items;
	private double appliedDiscounts;
	private double percentageDiscount;

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

	public double getTotalPrice() {
		double totalPrice = items.entrySet().stream().mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
				.sum();
		if (appliedDiscounts > 0) {
			totalPrice -= appliedDiscounts;
		}
		if (percentageDiscount > 0) {
			if (percentageDiscount > 100) {
				percentageDiscount = 100;
			}
			totalPrice = totalPrice - (totalPrice * (percentageDiscount / 100));
		}
		return totalPrice;
	}
}
