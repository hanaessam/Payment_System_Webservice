package refunds;

import org.springframework.stereotype.Component;

@Component
public class RefundRequest {
	private int transactionID;
	private int amount=0;
	private int userID;
	private String status;

	public RefundRequest() {
		this.transactionID = 0;
		this.amount = 0;
		this.userID = 0;
		this.status = "Pending";
	}
	
	public RefundRequest(int transactionId, int amount, int userID, String status) {
		this.transactionID = transactionId;
		this.amount = amount;
		this.userID = userID;
		this.status = status;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getTransactionID() {
		return transactionID;
	}
	public int getAmount() {
		return amount;
	}
	public int getUserID() {
		return userID;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setTransactionID(int id) {
		this.transactionID = id;
	}
	public String getStatus() {
		return status;
	}
}