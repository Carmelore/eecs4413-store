package models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public User findById(int id) {
		return jdbcTemplate.queryForObject("select * from Users where id=?", new BeanPropertyRowMapper<>(User.class), id);
	}
	
	public User findByUsername(String username) {
		return jdbcTemplate.queryForObject("select * from Users where username=?", new BeanPropertyRowMapper<>(User.class), username);
	}
	
	public List<User> findAll() {
		List<User> results = jdbcTemplate.query("select * from Users", new BeanPropertyRowMapper<>(User.class));
		return results;
	}
	
	public int create(String name, String username, String password) {
		return jdbcTemplate.update("insert into Users(name, username, password, admin) values(?,?,?,?)", name, username, password, false);
	}
}
