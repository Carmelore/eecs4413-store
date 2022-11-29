package ctrl.GroupV_Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import models.ProductJdbcRepository;


@RestController
public class ProductController {
	
	@Autowired
	ProductJdbcRepository repository;
	
	@GetMapping("/product")
	public String product(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
		return repository.findById(id).toString();
	}
	
	@GetMapping("/products")
	public String products(Model model) {
		return repository.findAll().toString();
	}
	
	
}