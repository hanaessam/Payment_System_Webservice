package Users;

import org.springframework.stereotype.Component;

@Component
public class User{
	private int id;
	private String username;
	private String email;
	private String password;
	public int walletBalance;
	public int mobileNumber;

	public User() {
		this.id=0;
		this.username = "";
		this.password = "";
		this.email = "";
		this.walletBalance = 0;
		this.mobileNumber = 0;
	}

	public User(int id,String username, String password, String email, int walletbalance, int mobilenumber) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.walletBalance = walletbalance;
		this.mobileNumber = mobilenumber;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(int walletBalance) {
		this.walletBalance = walletBalance;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}