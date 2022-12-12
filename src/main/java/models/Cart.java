package models;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
@Scope
public class Cart {
	  private Map<Product, Integer> items;

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
	    return items.entrySet().stream()
	        .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
	        .sum();
	  }
	}

