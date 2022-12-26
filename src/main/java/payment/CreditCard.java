package payment;

import org.springframework.stereotype.Component;

@Component
public class CreditCard {
	private int balance;
	private int amount;
	public CreditCard() {
		this.balance = balance;
		this.amount = amount;
	}
	public CreditCard(int balance, int amount){
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
}


