package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;

import models.Discount.discount_type;

@Scope
public class Cart {
	private ArrayList<Product> items;
	private ArrayList<Discount> discounts;

	  public Cart() {
	    this.items = new ArrayList<Product>();
	  }

	  public Cart(List<Product> products) {
		  this.items = (ArrayList<Product>) products;
	  }
	  
	  public void addItem(Product product) {
	    if (product == null || product.getAmount() <= 0) {
	      throw new IllegalArgumentException("Invalid product or amount");
	    }

	public Cart(List<Product> products) {
		this.items = (ArrayList<Product>) products;
	}

	public void addItem(Product product) {
		if (product == null || product.getAmount() <= 0) {
			throw new IllegalArgumentException("Invalid product or amount");
		}

		if (items.contains(product)) {
			product.setAmount(product.getAmount() + 1);
		}

		items.add(product);
	}

	public void removeItem(Product product) {
		if (product == null) {
			throw new IllegalArgumentException("Invalid product");
		}
		int index = items.indexOf(product);
		if (index != -1) {
			items.remove(index);
		}
	}

	public void updateAmount(Product product, int amount) {
		if (product == null || product.getAmount() <= 0 || amount <= 0) {
			throw new IllegalArgumentException("Invalid product or amount");
		}
		int index = items.indexOf(product);
		if (index != -1) {
			items.get(index).setAmount(amount);

		} else {
			throw new IllegalArgumentException("Product not present in cart");
		}
	}

	public List<Product> getItems() {
		return Collections.unmodifiableList(items);
	}

	public int getTotalQuantity() {
		return items.stream().filter(e -> e.getAmount() > 0).mapToInt(e -> e.getAmount()).sum();
	}

	public double getTotalPrice() {
		double subtotal = items.stream().filter(e -> e.getAmount() > 0).mapToDouble(e -> e.getAmount() * e.getPrice())
				.sum();
		double totalPrice = subtotal;
		double totalDiscounts=0;
		double percentageDiscount=0;
		for (Discount current : discounts) {
			if (current.getType().equals(discount_type.total) && current.getRequired_spending() > subtotal) {
				totalDiscounts += current.getDiscount();
			}
			if (current.getType().equals(discount_type.percent) && current.getRequired_spending() > subtotal) {
				percentageDiscount += current.getDiscount();
			}
		}
		totalPrice -= totalDiscounts;
		totalPrice = totalPrice * (1-(percentageDiscount/100));
		if (totalPrice < 0) {totalPrice = 0;}
		return totalPrice;
	}
}
