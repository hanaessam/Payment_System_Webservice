package Users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import security.Authentication;

@RestController
public class UserController {
	Authentication userBsl;
	
	public UserController(Authentication userBsl) {
		this.userBsl = userBsl;
	}
	
	@PostMapping(value="/users")
	public String registerUser(@RequestBody User user) {
		return userBsl.addUser(user);
	}
	
	@GetMapping(value="/users/{id}")
	public User loginUser(@PathVariable("id") int id) {
		return userBsl.getUser(id);
	}
	@GetMapping(value="/users/check/{id}")
	public String checkUser(@PathVariable("id") int id) {
		return userBsl.checkUser(id);
	}
}