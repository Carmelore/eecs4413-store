package ctrl.GroupV_Store;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import models.Product;
import models.ProductJdbcRepository;

@RestController
public class CheckoutController {
	@Autowired
	ProductJdbcRepository repository;
	
	
	@GetMapping("/checkout")
	public String checkout () {
		return "<h1>HELLO CHECKOUT</h1>";
		
	}
	
	@PostMapping(value = "/checkout", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public String submitCheckout (@RequestBody Map<String, String> data ) {
		System.out.println(data.keySet());
		System.out.println(data.get("items") + "REQUEST BODY");
		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		ArrayList<Product> items = gson.fromJson( data.get("items"), ArrayList.class);
		System.out.println(items.get(0).getName());
		return "success";
	}
}
