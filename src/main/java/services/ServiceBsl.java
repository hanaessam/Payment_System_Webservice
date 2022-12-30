package services;

import org.springframework.stereotype.Service;

@Service
public class ServiceBsl {
	static MobileRecharge mobileRecharge;
	static InternetPayment internetPayment;
	static Donations donations;
	static LandLine landLine;

	public ServiceBsl() {
		mobileRecharge = new MobileRecharge();
		internetPayment = new InternetPayment();
		donations = new Donations();
		landLine = new LandLine();
	}
	
	public static MobileRecharge getMobileRecharge() {
		return mobileRecharge;
	}
	public static InternetPayment getInternetPayment() {
		return internetPayment;
	}
	public static LandLine getLandLine() {
		return landLine;
	}
	public static Donations getDonations() {
		return donations;
	}
	

}
