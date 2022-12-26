package Users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	UserBsl userBsl;
	
	public UserController(UserBsl userBsl) {
		// TODO Auto-generated constructor stub
		this.userBsl = userBsl;
	}
	
	@PostMapping(value="/users")
	public String register(@RequestBody User user) {
		return userBsl.add(user);
	}
	
	@GetMapping(value="/users/{id}")
	public User login(@PathVariable("id") int id) {
		return userBsl.getUser(id);
	}
}