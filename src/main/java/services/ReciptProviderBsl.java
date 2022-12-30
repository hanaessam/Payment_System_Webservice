package services;

import org.springframework.stereotype.Service;

@Service
public class ReciptProviderBsl {
    static QuarterlyReceipt quarterlyReceipt; // 4
    static MonthlyReceipt monthlyReceipt; //1


	public ReciptProviderBsl() {
		quarterlyReceipt = new QuarterlyReceipt();
		monthlyReceipt = new MonthlyReceipt();
	
	}
	
	public static QuarterlyReceipt getquarterlyReceipt() {
		return quarterlyReceipt;
	}
	public static MonthlyReceipt getmonthlyReceipt() {
		return monthlyReceipt;
	}

	public static String transact(int providerId, int amount) {
		if(providerId == 4) {
			quarterlyReceipt.setTotalTransactionAmount(quarterlyReceipt.getTotalTransactionAmount() + amount);
			return "Quarterly Receipt generated  \n" ;
		}
		else if(providerId == 1){
			monthlyReceipt.setTotalTransactionAmount(monthlyReceipt.getTotalTransactionAmount() + amount);
			return "Monthly Receipt generated \n" ;
		}

		else {
			return "Receipt not found";
		}
	}

	public static boolean check(int providerId) {
		if(providerId==1 || providerId==4 ) {
			return true;
		}
		return false;
	}
}
