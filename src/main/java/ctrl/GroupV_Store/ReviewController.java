package ctrl.GroupV_Store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import models.Review;
import models.ReviewJdbcRepository;

@RestController
public class ReviewController {
	
	@Autowired
	ReviewJdbcRepository repository;
	
	@PostMapping("/reviews")
	public void addReview(@RequestBody String data) {
		Gson gson = new Gson();
		Review review = gson.fromJson(data, Review.class);
		
		repository.addReview(review.getReviewer(), review.getStars(), review.getDetails(), review.getProductId());
	}
	
	@GetMapping("/reviews")
	public String getProductReviews(@RequestParam(value = "id") int productId) {
		List<Review> reviews = repository.findReviews(productId);
		
		Gson gson = new Gson();
		return gson.toJson(reviews);
	}
}
