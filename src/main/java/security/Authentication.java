package security;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import Users.User;

@Service
public class Authentication {
	static ArrayList<User> users;
	
	public Authentication() {
		users = new ArrayList<>();
	}
	
	public String addUser(User user) {
		for(User userDB : users) {
			if(userDB.getId() == user.getId()) {
				return"ID already exist";
			}
			if(userDB.getUsername().equals( user.getUsername()))
			{
				return"User name already exist";
			}
			if(userDB.getEmail().equals(user.getEmail())) {
				return"Email already exist";
			}
		}
		users.add(user);
		return"User is added successfully";
	}
	
	public static User getUser(int id) {
		for(User userDB : users) {
			if(userDB.getId() == id) {
				return userDB;
			}
		}
		return null;
	}
	
	public static String login(String username, String password) {
		for(User userDB : users) {
			if(userDB.getUsername().equals(username)) {
				if(userDB.getPassword().equals(password)) {
					return "Success";
				}
			}
		}
		return "Incorrect username or password\nPlease try again";
	}
	
	public String checkUser(int id){
		for(User userDB : users) {
			if(userDB.getId() == id) {
				return "User exists";
			}
		}
		return "User is not found!";
	}
}