package payment;

public interface Payment {
	public int getTransactionId();
	public String getServiceName();
	public void setServiceName(String serviceName);
	public void setTransactionId(int transactionId);
	public int getUserId();
	public void setUserId(int userId);
	public int getAmount();
	public void setAmount(int amount);
	public int getAmountAfterDiscount();
	public void setAmountAfterDiscount(int amountAfterDiscount);
}