package refunds;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class RefundBsl {
	ArrayList<RefundRequest> refundRequests;
	
	public RefundBsl() {
		// TODO Auto-generated constructor stub
		refundRequests = new ArrayList<>();
	}
	
	public String add(RefundRequest request) {
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
				return  requestDB;
			}
		}
		return null;
	}
}