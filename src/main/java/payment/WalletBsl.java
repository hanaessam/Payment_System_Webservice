package payment;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class WalletBsl{
	static ArrayList<Wallet> wallets;
	
	public WalletBsl() {
		// TODO Auto-generated constructor stub
		wallets = new ArrayList<>();
	}
	
	public String calculatePayment(Wallet wallet, int transactionID) {
		if(security.Authentication.getUser(wallet.getUserId())==null)
			return "User not found.";	
		int walletBalance = security.Authentication.getUser(wallet.getUserId()).getWalletBalance();
		if(walletBalance == 0 || walletBalance<wallet.getAmount()) {
			return "Not enough points in wallet";
		}
		wallet.setTransactionId(transactionID);
		wallets.add(wallet);
		walletBalance-=wallet.getAmount();
		security.Authentication.getUser(wallet.getUserId()).setWalletBalance(walletBalance);
		return "Success!\nNew wallet balance: "+ walletBalance;
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
}