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
		return jdbcTemplate.queryForObject("select * from Product where id=?", new BeanPropertyRowMapper<>(Product.class), id);
	}
	
	public List<Product> findAll() {
		List<Product> results = jdbcTemplate.query("select * from Product", new BeanPropertyRowMapper<>(Product.class));
		return results;
	}
	
	public List<Product> findByType(String type) {
		List<Product> results = jdbcTemplate.query("select * from Product where type=?", new BeanPropertyRowMapper<>(Product.class), type);
		return results;
	}
	
	public List<Product> findByBrand(String brand) {
		List<Product> results = jdbcTemplate.query("select * from Product where brand=?", new BeanPropertyRowMapper<>(Product.class), brand);
		return results;
	}
}
