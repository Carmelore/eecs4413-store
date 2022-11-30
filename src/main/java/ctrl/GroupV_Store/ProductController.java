package ctrl.GroupV_Store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import models.Product;
import models.ProductJdbcRepository;


@RestController
public class ProductController {
	
	@Autowired
	ProductJdbcRepository repository;
	
	@GetMapping("/product")
	public String product(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
		String product = repository.findById(id).toString();
		Gson gson = new Gson();
		return gson.toJson(product);
	}
	
	@GetMapping("/products")
	public String products(Model model) {
		List<Product> products = repository.findAll();
		Gson gson = new Gson();
		return gson.toJson(products);
	}
}