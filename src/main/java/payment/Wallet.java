package payment;

import org.springframework.stereotype.Component;

import ch.qos.logback.core.joran.conditional.IfAction;

@Component
public class Wallet implements Payment{
	private int transactionId;
	private int userId;
	private int amount;
	private int amountAfterDiscount;
	private String serviceName;
	
	public Wallet() {
		this.transactionId = 0;
		this.userId = 0;
		this.amount = 0;
		this.amountAfterDiscount = 0;
		this.serviceName = " ";
	}
	public Wallet(int transactionId, int userId, int amount ,String serviceName ){
		this.transactionId = transactionId;
		this.userId = userId;
		this.amount = amount;
		this.serviceName = serviceName;
		this.amountAfterDiscount = amount;
	}
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
	public int getAmountAfterDiscount() {
		return amountAfterDiscount;
	}
	public void setAmountAfterDiscount(int amountAfterDiscount) {
		this.amountAfterDiscount = amountAfterDiscount;
	}
}