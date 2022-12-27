package payment;

import org.springframework.stereotype.Component;

@Component
public class CreditCard {
	private int transactionId;
	private int cardId;
	private int userId;
	private int balance;
	private int amount;
	public CreditCard() {
		this.transactionId = transactionId;
		this.cardId = cardId;
		this.userId = userId;
		this.balance = balance;
		this.amount = amount;
	}
	public CreditCard(int transactionId, int cardId, int userId, int balance, int amount){
		this.transactionId = transactionId;
		this.cardId = cardId;
		this.userId = userId;
		this.balance = balance;
		this.amount = amount;
	}
	public void setTransactionID(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getTransactionID() {
		return transactionId;
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
	public void setCardID(int id) {
		this.cardId = id;
	}
	public int getCardID() {
		return cardId;
	}
}