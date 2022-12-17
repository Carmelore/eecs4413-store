package ctrl.GroupV_Store;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
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
import com.google.gson.reflect.TypeToken;

import models.Cart;
import models.Product;
import models.ProductJdbcRepository;
import models.StatsJdbcRepository;
import models.User;

@RestController
public class CheckoutController {
	@Autowired
	StatsJdbcRepository repository;
	
	
	@GetMapping("/checkout")
	public String checkout () {
		return "<h1>HELLO CHECKOUT</h1>";
		
	}
	
	@PostMapping(value = "/checkout", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public String submitCheckout (@RequestBody Map<String, Object> data ) {
        Gson gson = new Gson();
        Type productList = new TypeToken<ArrayList<Product>>() {}.getType();
        Type userToken = new TypeToken<User>() {}.getType();
        String items = gson.toJson(data.get("items"));
        String userStr = gson.toJson(data.get("user"));
        List<Product> products = gson.fromJson(items, productList);
        User user = gson.fromJson(userStr, userToken);
        Cart cart = new Cart(products);
        products.forEach((product) -> {
            System.out.println(product.toString());
            int res = repository.createSale(user.getId(), product.getId(), product.getAmount());
            System.out.println("result: " + res);
        });
        return "success";
	}
}
