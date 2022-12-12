package ctrl.GroupV_Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import models.ProductJdbcRepository;

@RestController
public class CheckoutController {
	@Autowired
	ProductJdbcRepository repository;
	
	
	@GetMapping("/checkout")
	public String checkout () {
		return "<h1>HELLO CHECKOUT</h1>";
		
	}
	
	@PostMapping("/checkout")
	public String submitCheckout (@RequestParam("firstName") String firstName) {
		return firstName;
	}
}
