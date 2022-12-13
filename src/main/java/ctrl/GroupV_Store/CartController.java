package ctrl.GroupV_Store;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.http.HttpServletRequest;
import models.Cart;
import models.Product;

@RestController
@RequestMapping("/api/cart")
@SessionAttributes({"cart"})
public class CartController {
	  private Gson gson = new Gson();
  @ModelAttribute("cart")
  public Cart cart () {
	  return new Cart();
  }
  @GetMapping
  public Cart getCart(@SessionAttribute(required = false) Cart cart) {
	  if (cart == null) {
		  cart = new Cart();
		  return cart;
	  }
    return cart;
  }

  @PostMapping("/add")
  public Cart addToCart(@SessionAttribute(required = false) Cart cart, @RequestBody Map<String, String> requestBody) {
	    // Parse the request body as a JSON object
	    System.out.println(requestBody.get("cart"));
	    System.out.println(requestBody.keySet());
	    if (cart == null) {
	      // Initialize an empty Cart object if one does not exist in the session
	      cart = new Cart();
	    }
	    return cart;
	  }

  @PostMapping("/remove")
  public Cart removeFromCart(@SessionAttribute Cart cart, @RequestBody Product product) {
    cart.removeItem(product);
    return cart;
  }

  @PostMapping("/update")
  public Cart updateCart(@SessionAttribute Cart cart, @RequestBody Product product, @RequestBody int quantity) {
    cart.updateQuantity(product, quantity);
    return cart;
  }

}
