package ctrl.GroupV_Store;

import java.util.Map;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import models.StatsJdbcRepository;
//import models.Visit;

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

//	@GetMapping("/visits")
//	public String visits() {
//		return repository.findAll().toString();
//	}
//	
//	@PostMapping("/visits")
//	public int createVisit(@RequestBody String data) {
//		System.out.println(data);
//		
//		Gson gson = new Gson();
//		Visit visit = gson.fromJson(data, Visit.class);
//		return repository.createVisit(visit.getIp_address(), visit.getProduct_id(), visit.getStatus());
//	}
}