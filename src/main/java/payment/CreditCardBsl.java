package payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import org.springframework.stereotype.Service;

@Service
public class CreditCardBsl {
	private static Vector<HashMap<String, Integer>> addToWalletTransactions;
	private static ArrayList<CreditCard> creditCards;
	
	public CreditCardBsl() {
		creditCards = new ArrayList<>();
		addToWalletTransactions = new Vector<>();
	}
	
	public ArrayList<CreditCard> getCreditCards() {
		return creditCards;
	}

	public static void setCreditCards(ArrayList<CreditCard> creditCards) {
		CreditCardBsl.creditCards = creditCards;
	}

	public Vector<HashMap<String, Integer>> getAddToWalletTransactions() {
		return addToWalletTransactions;
	}

	public void setAddToWalletTransactions(Vector<HashMap<String, Integer>> addToWalletTransactions) {
		this.addToWalletTransactions = addToWalletTransactions;
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
				String userName =  security.Authentication.getUser(getCreditCard(id).getUserId()).getUsername();
				HashMap<String, Integer> transaction = new HashMap<>();
				transaction.put(userName, funds);
				addToWalletTransactions.add(transaction);
				break;
			}
		}
		return funds+" added to wallet successfully";
	}

	public static String calculatePayment(Payment creditCard, int transactionID) {
		if(security.Authentication.getUser(((CreditCard)creditCard).getUserId())==null)
			return "User not found.";
		if(((CreditCard)creditCard).getBalance() == 0 ||((CreditCard)creditCard).getBalance()<((CreditCard)creditCard).getAmountAfterDiscount()) {
			return "Not enough credit";
		}
		((CreditCard)creditCard).setTransactionID(transactionID);
		creditCards.add(((CreditCard)creditCard));
		int creditBalance = ((CreditCard)creditCard).getBalance()-((CreditCard)creditCard).getAmountAfterDiscount();
		((CreditCard)creditCard).setBalance(creditBalance);
		return "Success!\nTransaction ID: "+ transactionID+"\nNew credit balance: "+ creditBalance;
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
		for(CreditCard creditCardDB : creditCards) {
			if(creditCardDB.getTransactionID() == transactionId) {
				return creditCardDB;
			}
		}
		return null;
	}
}