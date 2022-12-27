package refunds;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

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
			if(requestDB.getID() == request.getID()) {
				return"Refund already requested";
			}
		}
		refundRequests.add(request);
		return"Refund is requested successfully";
	}
	
	public RefundRequest getRefund(int id) {
		for(RefundRequest requestDB : refundRequests) {
			if(requestDB.getID() == id) {
				return requestDB;
			}
		}
		return null;
	}
	
	public String checkRefund(int id){
		for(RefundRequest requestDB : refundRequests) {
			if(requestDB.getID() == id) {
				return "Refund request is found";
			}
		}
		return "Refund request is not found!";
	}
	
	//if refund accepted add the refunded amount to wallet
		public String setWalletBalance(int walletBalance) {
			for (RefundRequest refundreq : refundRequests) {
				if(refundreq.getStatus() == "accepted") {
				walletBalance+=refundreq.getAmount();
				return "Wallet balance is updated with the refunded amount: "+ walletBalance +" !";
				}
			}
			return "Wallet balance was not updated";
		}
}
