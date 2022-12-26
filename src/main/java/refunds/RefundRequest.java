package refunds;

import org.springframework.stereotype.Component;

@Component
public class RefundRequest {
	private int refundID;
	private int amount;
	private int userID;
	private String status;
	
	public RefundRequest() {
		this.refundID = 0;
		this.amount = 0;
		this.userID = 0;
		this.status = "Pending";
	}

	public RefundRequest(int id, int amount, int userID, String status) {
		this.refundID = id;
		this.amount = amount;
		this.userID = userID;
		this.status = status;
	}
	public int getID() {
		return refundID;
	}
	public int getAmount() {
		return amount;
	}
	public int getUserID() {
		return userID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}