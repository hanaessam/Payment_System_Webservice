package payment;

import org.springframework.stereotype.Component;

@Component
public class Wallet implements Payment{
	private int transactionId;
	private int userId;
	private int amount;
	private String serviceName;
	public int getTransactionId() {
		return transactionId;
	}
	public String getServiceName() {
		return serviceName;
	}
	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}