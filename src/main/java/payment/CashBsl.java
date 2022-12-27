package payment;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class CashBsl {
	static ArrayList<Cash> cash;
	public CashBsl() {
		// TODO Auto-generated constructor stub
		cash = new ArrayList<>();
	}
	
	public String calculatePayment(Cash cash, int transactionID) {
		if(security.Authentication.getUser(cash.getUserId())==null)
			return "User not found.";
		cash.setTransactionId(transactionID);
		this.cash.add(cash);
		return "Please pay "+ cash.getAmount() + " cash.";
	}
	
	public Cash getCash(int id) {
		for(Cash cashDB : cash) {
			if(cashDB.getUserId() == id) {
				return cashDB;
			}
		}
		return null;
	}
	
	public static Cash getCashByTransaction(int transactionId) {
		for(Cash cashDB : cash) {
			if(cashDB.getTransactionId() == transactionId) {
				return cashDB;
			}
		}
		return null;
	}
}