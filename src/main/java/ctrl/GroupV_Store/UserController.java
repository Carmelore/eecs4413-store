package ctrl.GroupV_Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

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
	public int user(@RequestBody String data) {
		Gson gson = new Gson();
		User user = gson.fromJson(data, User.class);
		
		return repository.create(user.getName(), user.getUsername(), user.getPassword());
	}
}