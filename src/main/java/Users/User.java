package Users;

import org.springframework.stereotype.Component;

@Component
public class User{
	private int id;
	private String username;
	private String email;
	private String password;
	private int walletBalance;

	public User() {
		this.id=0;
		this.username = "";
		this.password = "";
		this.email = "";
		this.walletBalance = 0;
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