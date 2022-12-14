package models;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductJdbcRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public Product findById(int id) {
		return jdbcTemplate.queryForObject("select * from Products where id=?", new BeanPropertyRowMapper<>(Product.class), id);
	}
	
	public List<Product> findAll() {
		List<Product> results = jdbcTemplate.query("select * from Products", new BeanPropertyRowMapper<>(Product.class));
		return results;
	}
	
	public List<Product> findByType(String type) {
		List<Product> results = jdbcTemplate.query("select * from Products where type=?", new BeanPropertyRowMapper<>(Product.class), type);
		return results;
	}
	
	public List<Product> findByBrand(String brand) {
		List<Product> results = jdbcTemplate.query("select * from Products where brand=?", new BeanPropertyRowMapper<>(Product.class), brand);
		return results;
	}
	
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
