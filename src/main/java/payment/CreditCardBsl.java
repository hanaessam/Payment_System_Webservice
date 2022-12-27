package payment;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import refunds.RefundRequest;
import security.Authentication;

@Service
public class CreditCardBsl implements Payment {
	ArrayList<CreditCard> creditCards;
	public CreditCardBsl() {
		creditCards = new ArrayList<>();
	}
	
//	public int calculatePayment(int balance, int amount) {
//		balance = balance - amount;
//		return balance;
//	}
//	
	public int addToWallet(int balance, int funds) {
		balance = balance - funds;
		return balance;
	}

	public String calculatePayment(int id, int amount) {
		for (CreditCard creditCard : creditCards) {
			if(creditCard.getUserId() == id) {
				if(creditCard.getBalance() == 0 || creditCard.getBalance()<amount) {
					return "Not enough credit";
				}
				creditCard.setBalance(creditCard.getBalance() - amount);
			}
		}
		return "Success!";
	}
	
	public String addCreditCard(CreditCard creditCard) {
		if(Authentication.getUser(creditCard.getUserId())== null) {
			return "User is not found";
		}
		for(CreditCard creditCardDB : creditCards) {
			if(creditCardDB.getId() == creditCard.getId()) {
				return "CreditCard already exists.";
			}
		}
		creditCards.add(creditCard);
		return"CreditCard info added successfully";
	}
	
	public CreditCard getCreditCard(int id) {
		for(CreditCard creditCardDB : creditCards) {
			if(creditCardDB.getId() == id) {
				return creditCardDB;
			}
		}
		return null;
	}
	
}
