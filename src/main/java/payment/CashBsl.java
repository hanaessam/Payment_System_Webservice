package payment;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class CashBsl {
	static ArrayList<Cash> cashs;
	public CashBsl() {
		cashs = new ArrayList<>();
	}
	
	public static String calculatePayment(Payment cash, int transactionID) {
		if(security.Authentication.getUser( ((Cash)cash).getUserId())==null)
			return "User not found.";
		((Cash)cash).setTransactionId(transactionID);
		cashs.add(((Cash)cash));
		return "Please pay "+ ((Cash)cash).getAmountAfterDiscount() + " cash.\nTransaction ID: "+ transactionID;
	}
	
	public Cash getCash(int id) {
		for(Cash cashDB : cashs) {
			if(cashDB.getUserId() == id) {
				return cashDB;
			}
		}
		return null;
	}
	
	public static Cash getCashByTransaction(int transactionId) {
		for(Cash cashDB : cashs) {
			if(cashDB.getTransactionId() == transactionId) {
				return cashDB;
			}
		}
		return null;
	}
	public ArrayList<Cash> getCashs() {
		return cashs;
	}
}