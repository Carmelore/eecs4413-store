package ctrl.GroupV_Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import models.User;
import models.UserJdbcRepository;


@RestController
public class UserController {
	
	@Autowired
	UserJdbcRepository repository;
	
	@GetMapping("/user")
	public String user(@RequestParam(value = "id", defaultValue = "1") int id) {
		return repository.findById(id).toString();
	}
	
	@GetMapping("/users")
	public String users() {
		return repository.findAll().toString();
	}
	
	@PostMapping("/users")
	public String user(@RequestBody String user) {
		System.out.println(user);
		return null;
	}
}