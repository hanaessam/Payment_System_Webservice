package payment;

import org.springframework.stereotype.Component;

@Component
public class CreditCard implements Payment{
	private int transactionId;
	private int cardId;
	private int userId;
	private int balance;
	private int amount;
	private String serviceName;
	public CreditCard() {
		this.transactionId = transactionId;
		this.cardId = cardId;
		this.userId = userId;
		this.balance = balance;
		this.amount = amount;
		this.serviceName = serviceName;
	}
	public CreditCard(int transactionId, int cardId, int userId, int balance, int amount ,String serviceName ){
		this.transactionId = transactionId;
		this.cardId = cardId;
		this.userId = userId;
		this.balance = balance;
		this.amount = amount;
		this.serviceName = serviceName;
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
	public void setServiceName(String serviceName) {
		 this.serviceName=serviceName;
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
	public String getServiceName() {
		return serviceName;
	}
	
}