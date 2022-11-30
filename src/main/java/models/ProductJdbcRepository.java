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
}
