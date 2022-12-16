package models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import models.Discount.discount_type;

@Repository
public class DiscountJdbcRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public Discount findById(int id) {
		return jdbcTemplate.queryForObject("select * from Discounts where id=?",
				new BeanPropertyRowMapper<>(Discount.class), id);
	}

	public Discount findByDiscountCode(String code) {
		return jdbcTemplate.queryForObject("select * from Discounts where code=?",
				new BeanPropertyRowMapper<>(Discount.class), code);
	}

	public List<Discount> findAll() {
		List<Discount> results = jdbcTemplate.query("select * from Discounts",
				new BeanPropertyRowMapper<>(Discount.class));
		return results;
	}

	public int create(String code, int discount, int requiredSpending, discount_type type) {
		if (validateNewDiscount(code, discount, requiredSpending, type)) {
			return jdbcTemplate.update("insert into Discounts(code, discount, requiredSpending, type) values(?,?,?,?,?)",
					code, discount, requiredSpending, type, false);
		} else {
			return 0;
		}
	}

	public boolean validateNewDiscount(String code, int discount, int requiredSpending, discount_type type) {
		if ((code.length() > 15 || code.length() < 0)
				|| discount < 0
				|| !(type.equals(discount_type.total) || type.equals(discount_type.percent))
				|| (type.equals(discount_type.percent) && discount > 100)) {
			return false;
		} else {
			return true;
		}
	}
}
