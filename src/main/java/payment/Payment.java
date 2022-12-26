package payment;

public interface Payment {
	public int calculateCreditCardPayment(int balance , int amount);
	public int calculateWalletPayment(int walletBalance , int amount);
}
