package payment;

import org.springframework.stereotype.Component;

@Component
public class CreditCard implements Payment{
	private int transactionId;
	private int cardId;
	private int userId;
	private int balance;
	private int amount;
	private int amountAfterDiscount;
	private String serviceName;
	
	public CreditCard() {
		this.transactionId = 0;
		this.cardId = 0;
		this.userId = 0;
		this.balance = 0;
		this.amount = 0;
		this.amountAfterDiscount = 0;
		this.serviceName = " ";
	}
	public CreditCard(int transactionId, int cardId, int userId, int balance, int amount ,String serviceName ){
		this.transactionId = transactionId;
		this.cardId = cardId;
		this.userId = userId;
		this.balance = balance;
		this.amount = amount;
		this.serviceName = serviceName;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getTransactionId() {
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
	public int getAmountAfterDiscount() {
		return amountAfterDiscount;
	}
	public void setAmountAfterDiscount(int amountAfterDiscount) {
		this.amountAfterDiscount = amountAfterDiscount;
	}
}