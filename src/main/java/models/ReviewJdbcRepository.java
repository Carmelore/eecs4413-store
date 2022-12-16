package models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewJdbcRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addReview(String reviewer, int stars, String details, int productId) {
		int result = jdbcTemplate.update("insert into Reviews(reviewer, stars, details, product_id) values (?,?,?,?)",
				reviewer, stars, details, productId);
		return result;
	}
	
	public List<Review> findReviews(int productId) {
		List<Review> results = jdbcTemplate.query("select * from Reviews where product_id=?", new BeanPropertyRowMapper<>(Review.class), productId);
		return results;
	}
}
