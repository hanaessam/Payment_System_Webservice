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
	static int userId = 0;
	
	public UserController(Authentication userBsl) {
		this.userBsl = userBsl;
	}
	
	@PostMapping(value="/users/signup")
	public String registerUser(@RequestBody User user) {
		userId++;
		user.setId(userId);
		return userBsl.addUser(user) + "\nUser ID : "+userId;
	}
	
	@GetMapping(value="/users/{id}")
	public User getUser(@PathVariable("id") int id) {
		return userBsl.getUser(id);
	}
	
	@GetMapping(value="/users/login/{username}/{password}")
	public String loginUser(@PathVariable("username") String username, @PathVariable("password") String password) {
		return userBsl.login(username, password);
	}
	
	@GetMapping(value="/users/check/{id}")
	public String checkUser(@PathVariable("id") int id) {
		return userBsl.checkUser(id);
	}
}