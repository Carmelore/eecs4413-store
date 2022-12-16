package models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StatsJdbcRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public HashMap<String, Integer> monthlySales() {
		LocalDate currentMonth = LocalDate.now().withDayOfMonth(1);
		List<Map<String, Object>> result = jdbcTemplate.queryForList("SELECT Products.name, Sales.quantity FROM Sales "
				+ "INNER JOIN Products ON Products.id = Sales.product_id "
				+ "WHERE Sales.created_at >= ?",
				currentMonth.toString());
		
		HashMap<String, Integer> sales = new HashMap<>();
		result.forEach(sale -> {
			String product = (String) sale.get("NAME");
			int quantity = (int) sale.get("QUANTITY");
			int current = 0;
			
			if (sales.keySet().contains(product)) {
				current = sales.get(product);
			}
			sales.put(product, current + quantity);
		});
		
		return sales;
	}

//	public int createVisit(String ipa, int product, Visit.status status) {
//		return jdbcTemplate.update("insert into Visits(ip_address, created_at, product_id, status) values(?,?,?,?)",
//				ipa, LocalDate.now(), product, status);
//	}
//	
//	public List<Visit> findAll() {
//		List<Visit> results = jdbcTemplate.query("select * from Visits", new BeanPropertyRowMapper<>(Visit.class));
//		return results;
//	}
}
