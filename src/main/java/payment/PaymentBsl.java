package payment;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import refunds.RefundBsl;
import refunds.RefundRequest;

@Service
public class PaymentBsl implements Payment {
	ArrayList<CreditCard> creditCardTransactions; 
	ArrayList<Wallet> walletTransactions;
	RefundBsl refundBsl;
	
	public PaymentBsl() {
		creditCardTransactions = new ArrayList<>();
		walletTransactions = new ArrayList<>();
	}

	public int calculateCreditCardPayment(int balance, int amount) {
		balance = balance - amount;
		return balance;
	}
	public int calculateWalletPayment(int walletBalance, int amount) {
		walletBalance = walletBalance - amount;
		return walletBalance;
	}
	
	public String ceckPayment(int balance, int amount) {
		if(balance == 0 || balance<amount) {
			return "Not enough credit";
		}
		balance = balance - amount;
		return "Success!";
	}
	public int addToWallet(int balance, int funds) {
		balance = balance - funds;
		return balance;
	}
	public String checkWalletFunds(int walletBalance, int funds) {
		if(walletBalance == 0 ||walletBalance<funds) {
			return "Not enough credit";
		}
		walletBalance = walletBalance - funds;
		return "Added to wallet.";
	}

	public void addFundsToWallet(int walletBalance, int funds) {
		if( checkWalletFunds(walletBalance,funds) == "Added to wallet." ){
			walletBalance = walletBalance + funds;
		}
	}
	
	
}
