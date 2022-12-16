package ctrl.GroupV_Store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

import models.Product;
import models.ProductJdbcRepository;


@RestController
public class ProductController {
	
	@Autowired
	ProductJdbcRepository repository;
	
	@GetMapping("/product")
	public String product(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
		Product product = repository.findById(id);
		Gson gson = new Gson();
		return gson.toJson(product);
	}
	
	@GetMapping("/products")
	public String products(@RequestParam(value = "type", defaultValue = "") String type, @RequestParam(value = "brand", defaultValue = "") String brand, Model model) {
		
		type = type.trim();
		brand = brand.trim();
		List<Product> products;
		if (!type.isEmpty()) {
			products = repository.findByType(type);
		}
		else if (!brand.isEmpty()) {
			products = repository.findByBrand(brand);
		}
		else {
			products = repository.findAll();
		}
		Gson gson = new Gson();
		return gson.toJson(products);
	}
}