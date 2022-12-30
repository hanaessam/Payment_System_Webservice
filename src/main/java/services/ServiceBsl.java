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
	
//	public String addServiceProvider(ServiceProvider serviceProvider) {
//		for(ServiceProvider serviceProviderDB : serviceProviders) {
//			if(serviceProviderDB.getName().equals(serviceProvider.getName())) {
//					return "This service provider already exists!";	
//			}
//		}
//		serviceProviders.add(serviceProvider);
//		return "Service provider: " +serviceProvider.getName()+ " added successfully!";
//	}

//	public Service searchService(String name) {
//		if(name.equals("MobileRecharge"))
//			return (Service) mobileRecharge;
//		else if(name.equals("InternetPayment"))
//			return (Service) internetPayment;
//		else if(name.equals("LandLine"))
//			return (Service) landLine;
//		else if(name.equals("Donation"))
//			return (Service) donations;
//		return null;
//	}
}
