package payment;

import org.springframework.stereotype.Component;

@Component
public class Wallet implements Payment{
	private int transactionId;
	private static int userId;
	private  int amount;
	private String serviceName;
	private int id;
	private int walletBalance;
	
	public String getserviceName() {
		return serviceName;
	}
	
	public void setserviceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public static int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public  int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setid(int id) {
		this.id = id;
	}
}
