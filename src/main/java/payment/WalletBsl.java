package payment;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class WalletBsl{
	static ArrayList<Wallet> wallets;
	
	public WalletBsl() {
		wallets = new ArrayList<>();
	}
	
	public static String calculatePayment(Payment wallet, int transactionID) {
		if(security.Authentication.getUser(((Wallet)wallet).getUserId())==null)
			return "User not found.";	
		int walletBalance = security.Authentication.getUser(((Wallet)wallet).getUserId()).getWalletBalance();
		if(walletBalance == 0 || walletBalance<((Wallet)wallet).getAmountAfterDiscount()) {
			return "Not enough points in wallet";
		}
		((Wallet)wallet).setTransactionId(transactionID);
		wallets.add(((Wallet)wallet));
		walletBalance-=((Wallet)wallet).getAmountAfterDiscount();
		security.Authentication.getUser(((Wallet)wallet).getUserId()).setWalletBalance(walletBalance);
		return "Success!\nTransaction ID: "+ transactionID+"\nNew wallet balance: "+ walletBalance;
	}
	
	public Wallet getWallet(int id) {
	
		for(Wallet walletDB : wallets) {
			if(walletDB.getUserId() == id) {
				return walletDB;
			}
		}
		return null;
	}
	public static Wallet getWalletByTransaction(int transactionId) {
		for(Wallet walletDB : wallets) {
			if(walletDB.getTransactionId() == transactionId) {
				return walletDB;
			}
		}
		return null;
	}
	
	public ArrayList<Wallet> getWallets() {
		return wallets;
	}
}