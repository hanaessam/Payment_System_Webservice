package Users;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class UserBsl {
	ArrayList<User> users;
	
	public UserBsl() {
		// TODO Auto-generated constructor stub
		users = new ArrayList<>();
	}
	
	public String add(User user) {
		for(User userDB : users) {
			if(userDB.getID() == user.getID()) {
				return"ID already exist";
			}
		}
		users.add(user);
		return"User is added successfully";
	}
	
	public User getUser(int id) {
		for(User userDB : users) {
			if(userDB.getID() == id) {
				return userDB;
			}
		}
		return null;
	}
}
