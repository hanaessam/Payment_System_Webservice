package refunds;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import payment.Wallet;

@RestController
public class RefundController implements Subject {
	RefundBsl refundBsl;
	
	public RefundController(RefundBsl refundBsl) {
		this.refundBsl = refundBsl;
	}
	
	@PostMapping(value="/refunds")
	public String requestRefund(@RequestBody RefundRequest refund) {
		return refundBsl.addRefund(refund);
	}
	
	@GetMapping(value="/refunds/{id}")
	public RefundRequest getRefund(@PathVariable("id") int id) {
		return refundBsl.getRefund(id);
	}
	
	@GetMapping(value="/refunds/check/{id}")
	public String checkRefund(@PathVariable("id") int id) {
		return refundBsl.checkRefund(id);
	}
	
	@GetMapping(value="/refunds/listTransactions")
	public ArrayList<RefundRequest> listRefundTransactions() {
		return refundBsl.refundRequests;
	}
	
	@PutMapping(value="/refunds/{id}/{status}")
	public String adminResponse(@PathVariable("id") int id, @PathVariable ("status") Boolean status) {
		if(refundBsl.getRefund(id)==null)
			return "Refund request not found.";
		RefundRequest request = refundBsl.getRefund(id);
		if(status)
			request.setStatus("accepted");
		else {
			request.setStatus("rejected");
		}
		return "refund is " + request.getStatus() + "\n" + refundBsl.setWalletBalance(request, status);
	}
	
//	public void subscribe(Observer userObserver) {
//		RefundController.userObserver = (User) userObserver;
//		System.out.println(User.username);
//			requests.put(((User) userObserver).userRequestList,((User) userObserver).refundedAmount);
//			System.out.println(requests);
//	}
//	public void unSubscribe(Observer observer) {
//		RefundController.userObserver = (User) userObserver;
//		System.out.println(User.username);
//			requests.remove(((User) userObserver).userRequestList,((User) userObserver).refundedAmount);
//			System.out.println(requests);
//	};
//	
//	public void notifyObservers(String message) {
//        for (User user : userForm.users) {
//            user.update();
//        }
//	}
}