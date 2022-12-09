package ctrl.GroupV_Store;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public int user(@RequestBody String data) throws Exception {
		Gson gson = new Gson();
		User user = gson.fromJson(data, User.class);
		String name = user.getName();
		String username = user.getUsername();
		String password = user.getPassword();
	
		if (!validateName(name) || !validateUsername(username) || password.length() < 8) {
			throw new Exception("Invalid info");
		}
		
		return repository.create(name, username, password, user.getShipping_address(), user.getBilling_address());
	}
	
	@PostMapping("/login")
	public void login(@RequestBody String data) throws Exception {
		Gson gson = new Gson();
		User user = gson.fromJson(data, User.class);
		
		if (!repository.verify(user.getUsername(), user.getPassword())) {
			throw new Exception("invalid login");
		}
	}

	private boolean validateName(String name) {
		Pattern pattern = Pattern.compile("^[a-zA-ZÀ-ž-' ]+$");
		Matcher matcher = pattern.matcher(name);
		return matcher.find();
	}
	
	private boolean validateUsername(String username) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9-_]+$");
		Matcher matcher = pattern.matcher(username);
		return matcher.find();
	}
	
}