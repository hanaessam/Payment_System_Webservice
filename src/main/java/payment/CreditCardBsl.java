package payment;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import services.MobileRecharge;

@Service
public class CreditCardBsl {
	private static ArrayList<CreditCard> creditCards;
	public CreditCardBsl() {
		setCreditCards(new ArrayList<>());
	}

	public String addToWallet(int id, int funds) {
		if(getCreditCard(id)==null)
			return "Credit card not found.";
		for (CreditCard creditCard : getCreditCards()) {
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

	public String calculatePayment(Payment creditCard, int transactionID) {
		if(security.Authentication.getUser(((CreditCard)creditCard).getUserId())==null)
			return "User not found.";
		if(((CreditCard)creditCard).getBalance() == 0 ||((CreditCard)creditCard).getBalance()< MobileRecharge.getAmount()) {
			return "Not enough credit";
		}
		((CreditCard)creditCard).setTransactionID(transactionID);
		((CreditCard)creditCard).setAmount(MobileRecharge.getAmount());
		getCreditCards().add(((CreditCard)creditCard));
		int creditBalance = ((CreditCard)creditCard).getBalance()-((CreditCard)creditCard).getAmount();
		((CreditCard)creditCard).setBalance(creditBalance);
		return "Success!\nNew credit balance: "+ creditBalance;
	}
	
//	public String addCreditCard(CreditCard creditCard) {
//		if(security.Authentication.getUser(creditCard.getUserId()) == null) {
//			return "User is not found";
//		}
//		for(CreditCard creditCardDB : creditCards) {
//			if(creditCardDB.getCardID() == creditCard.getCardID()) {
//				return "CreditCard already exists.";
//			}
//		}
//		creditCards.add(creditCard);
//		return"CreditCard info added successfully";
//	}
	
	public CreditCard getCreditCard(int cardId) {
		for(CreditCard creditCardDB : getCreditCards()) {
			if(creditCardDB.getCardID() == cardId) {
				return creditCardDB;
			}
		}
		return null;
	}
	
	public static CreditCard getCreditCardByTransaction(int transactionId) {
		for(CreditCard creditCardDB : getCreditCards()) {
			if(creditCardDB.getTransactionID() == transactionId) {
				return creditCardDB;
			}
		}
		return null;
	}
	public static CreditCard getCreditCardByUserId(int userId) {
		for(CreditCard creditCardDB : getCreditCards()) {
			if(creditCardDB.getUserId() == userId) {
				return creditCardDB;
			}
		}
		return null;
	}
	

	public static ArrayList<CreditCard> getCreditCards() {
		return creditCards;
	}

	public static void setCreditCards(ArrayList<CreditCard> creditCards) {
		CreditCardBsl.creditCards = creditCards;
	}
}