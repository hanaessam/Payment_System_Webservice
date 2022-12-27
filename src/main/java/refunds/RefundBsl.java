package refunds;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import payment.CreditCard;
import payment.PaymentBsl;
import security.Authentication;

@Service
public class RefundBsl {
	public ArrayList<RefundRequest> refundRequests;
	
	public RefundBsl() {
		refundRequests = new ArrayList<>();
	}
	
	public String addRefund(RefundRequest request) {
		if(Authentication.getUser(request.getUserID())== null) {
			return "User is not found";
		}
		for(RefundRequest requestDB : refundRequests) {
			if(requestDB.getTransactionID() == request.getTransactionID()) {
				return "Refund is already requested";
			}
		}
		if(payment.CreditCardBsl.getCreditCardByTransaction(request.getTransactionID())!=null) {
			request.setAmount(payment.CreditCardBsl.getCreditCardByTransaction(request.getTransactionID()).getAmount());
			refundRequests.add(request);
			return"Refund is requested successfully";
		}
		if(payment.CashBsl.getCashByTransaction(request.getTransactionID())!=null ) {
			request.setAmount(payment.CashBsl.getCashByTransaction(request.getTransactionID()).getAmount());
			refundRequests.add(request);
			return"Refund is requested successfully";
		}
		if(payment.WalletBsl.getWalletByTransaction(request.getTransactionID())!=null ) {
			request.setAmount(payment.WalletBsl.getWalletByTransaction(request.getTransactionID()).getAmount());
			refundRequests.add(request);
			return"Refund is requested successfully";
		}
		return"Transaction not found.";
	}
	
	public RefundRequest getRefund(int id) {
		for(RefundRequest requestDB : refundRequests) {
			if(requestDB.getTransactionID() == id) {
				return requestDB;
			}
		}
		return null;
	}
	
	public String checkRefund(int id){
		for(RefundRequest requestDB : refundRequests) {
			if(requestDB.getUserID() == id) {
				return "Refund request is found";
			}
		}
		return "Refund request is not found!";
	}
	
	public String setWalletBalance(RefundRequest request, Boolean status) {
		if(status) {
			int newWalletBalance = security.Authentication.getUser(request.getUserID()).getWalletBalance() + request.getAmount();
			security.Authentication.getUser(request.getUserID()).setWalletBalance(newWalletBalance);
			return "Wallet balance is updated with the refunded amount: "+ newWalletBalance +" !";
		}
		return "Wallet balance was not updated";
	}
}
