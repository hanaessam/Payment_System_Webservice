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
	
	public String checkUser(int id){
		for(User userDB : users) {
			if(userDB.getId() == id) {
				return "User exists";
			}
		}
		return "User is not found!";
	}
  
}