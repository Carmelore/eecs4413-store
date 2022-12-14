package ctrl.GroupV_Store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import models.Product;
import models.ProductJdbcRepository;
import models.Review;


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
	
	@PostMapping("/reviews")
	public void addReview(@RequestBody String data) {
		Gson gson = new Gson();
		Review review = gson.fromJson(data, Review.class);
		
		repository.addReview(review.getReviewer(), review.getStars(), review.getDetails(), review.getProductId());
	}
	
	@GetMapping("/reviews")
	public String getProductReviews(int productId) {
		return "";
	}
}