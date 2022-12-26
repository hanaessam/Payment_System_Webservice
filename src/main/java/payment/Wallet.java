package payment;

import org.springframework.stereotype.Component;

@Component
public class Wallet {
	private int walletBalance;
	private int amount;
	private int funds;
	public Wallet() {
		this.walletBalance = walletBalance;
		this.amount = amount;
		this.funds = funds;
	}
	public Wallet(int walletBalance, int amount, int funds){
		this.walletBalance = walletBalance;
		this.amount = amount;
		this.funds = funds;
	}
	public int getAmount() {
		return amount;
	}
	public int getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(int balance) {
		this.walletBalance = walletBalance;
	}
	public int getFunds() {
		return funds;
	}
	public void setFunds(int funds) {
		this.funds = funds;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
