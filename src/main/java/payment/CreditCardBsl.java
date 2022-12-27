package payment;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class CreditCardBsl implements Payment {
	ArrayList<CreditCard> creditCards;
	public CreditCardBsl() {
		creditCards = new ArrayList<>();
	}

	public String addToWallet(int id, int funds) {
		if(getCreditCard(id)==null)
			return "Credit card not found.";
		for (CreditCard creditCard : creditCards) {
			if(creditCard.getUserId() == id) {
				if(creditCard.getBalance() == 0 || creditCard.getBalance()<funds) {
					return "Not enough credit";
				}
				int walletBalance = security.Authentication.getUser(getCreditCard(id).getUserId()).getWalletBalance();
				security.Authentication.getUser(getCreditCard(id).getUserId()).setWalletBalance(walletBalance+funds);
				break;
			}
		}
		return funds+" added to wallet successfully";
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
		if(security.Authentication.getUser(creditCard.getUserId()) == null) {
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