package refunds;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefundController implements Subject {
	RefundBsl refundBsl;
	
	public RefundController(RefundBsl refundBsl) {
		// TODO Auto-generated constructor stub
		this.refundBsl = refundBsl;
	}
	
	@PostMapping(value="/refunds")
	public String requestRefund(@RequestBody RefundRequest refund) {
		return refundBsl.add(refund);
	}
	
	@GetMapping(value="/refunds/{id}")
	public RefundRequest login(@PathVariable("id") int id) {
		return refundBsl.getRefund(id);
	}
	
	@PutMapping(value="/refunds/{id}/{status}")
	public RefundRequest adminResponse(@PathVariable("id") int id, @PathVariable ("status") String status) {
		RefundRequest request = refundBsl.getRefund(id);
		request.setStatus(status);
		return request;
	}
	
//	public static final Map<List<String>,Integer> requests = new HashMap<>();
//	public static String accepted;
//	public static Form form;
//	private static Scanner myObj = new Scanner(System.in);
//	public static Observer userObserver;
//	public static String observerUsername;
//	MainForm userForm;
//	
//	public static HashMap<List<String>, Integer> getAdminResponse(List<User> users) {
//		for (List<String> i : requests.keySet()) {
//			if(i.size() != 2) {
//				System.out.println("1-enter 'a' for Accepted \n2-enter 'r' for  Rejecterd");
//				String accepted = myObj.next();
//				if (!(i.contains("a") && i.contains("r"))) {
//					i.add(accepted);
//				}
//				System.out.println(requests);
//				for(int j=0;j<users.size();j++) {
//					if(users.get(j).username == i.get(0) && accepted == "a" && accepted == "r") {
//						((Wallet)users.get(j).wallet).setWalletBalance(requests.get(i));
//						break;
//					}
//				}
//			}
//		}
//		return (HashMap<List<String>, Integer>) requests;
//	}
//	
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