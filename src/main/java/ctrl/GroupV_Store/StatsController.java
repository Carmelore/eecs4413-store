package ctrl.GroupV_Store;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import models.StatsJdbcRepository;
import models.Visit;

@RestController
public class StatsController {

	@Autowired
	StatsJdbcRepository repository;
	
	@GetMapping("/sales")
	public String sales() {
		Map<String, Integer> sales = repository.monthlySales();
		
		StringJoiner result = new StringJoiner(",", "[", "]");
		sales.forEach((product, quantity) -> {
			result.add("{\"product\":\"" + product + "\",\"quantity\":" + quantity + "}");
		});
		
		return result.toString();
	}

	@GetMapping("/visits")
	public String visits() {
		List<Map<String, Object>> visits = repository.getVisits();
		
		StringJoiner result = new StringJoiner(",", "[", "]");
		visits.forEach(visit -> {
			Date date = (Date) visit.get("CREATED_AT");
			String ipa = (String) visit.get("IP_ADDRESS");
			String product = (String) visit.get("NAME");
			String status = (String) visit.get("STATUS");
			
			result.add("{\"date\":\"" + date + "\",\"ipa\":\"" + ipa
					+ "\",\"product\":\"" + product + "\",\"status\":\"" + status + "\"}");
		});
		
		return result.toString();
	}
	
	@PostMapping("/visits")
	public int createVisit(@RequestBody String data) {
		Gson gson = new Gson();
		Visit visit = gson.fromJson(data, Visit.class);
		
		return repository.createVisit(visit.getIpAddress(), visit.getProductId(), visit.getStatus());
	}
}