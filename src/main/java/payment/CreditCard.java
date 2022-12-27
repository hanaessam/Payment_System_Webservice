package payment;

import org.springframework.stereotype.Component;


@Component
public class CreditCard {
	private int id;
	private int userId;
	private int balance;
	private int amount;
	public CreditCard() {
		this.id = id;
		this.userId = userId;
		this.balance = balance;
		this.amount = amount;
	}
	public CreditCard(int id, int userId, int balance, int amount){
		this.id = id;
		this.userId = userId;
		this.balance = balance;
		this.amount = amount;
	}
	public int getAmount() {
		return amount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}


