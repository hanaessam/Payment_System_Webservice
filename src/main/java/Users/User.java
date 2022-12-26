package Users;

import org.springframework.stereotype.Component;

@Component
public class User{
	private int id;
	private String username;
	private String email;
	private String password;

	public User() {
		this.id=0;
		this.username = "";
		this.password = "";
		this.email = "";
	}

	public User(int id,String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public int getID() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
}