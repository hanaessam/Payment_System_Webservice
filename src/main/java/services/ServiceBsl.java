package services;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import Users.User;
import payment.CreditCard;
import payment.CreditCardBsl;
import security.Authentication;
@Service
public class ServiceBsl {
	static ArrayList<MobileRecharge>  mobileRecharges;
	static InternetPayment internetPayment;
	static Donations donations;
	static LandLine landLine;

	public ServiceBsl() {
		mobileRecharges = new ArrayList<>();
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
	
//	public Service getService(int id) {
//		if(id==1)
//			return ((MobileRecharge mobileRecharge);
//		else if(id==2)
//			return (Service) internetPayment;
//		else if(id==3)
//			return (Service) landLine;
//		else if(id==4)
//			return (Service) donations;
//		return null;
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
	
	
		public String addMobileRecharge(MobileRecharge mobileRecharge) {
	//		mobileRecharge.setAmount(payment.CreditCardBsl.getCreditCardByUserId(mobileRecharge.getUserId()).getAmount());
			if(security.Authentication.getUser(mobileRecharge.getUserId())==null)
				return "User not found.";
			
			getMobileRecharges().add(mobileRecharge);
			return "Success!\n your amount: "+ mobileRecharge.getAmount() +" .";
		}
	
	public static ArrayList<MobileRecharge> getMobileRecharges() {
		return mobileRecharges;
	}

	
	public static MobileRecharge getMobileRecharge(int userId) {
		for(MobileRecharge mobileRechargeDB : getMobileRecharges()) {
			if(mobileRechargeDB.getUserId() == userId) {
				return mobileRechargeDB;
			}
		}
		return null;
	}
	
	public InternetPayment getInternetPayment(int id) {
		if(id == 2) {
			return internetPayment;
		}
		return null;
	}
	public LandLine getLandLine(int id) {
		if(id == 3) {
			return landLine;
		}
		return null;
	}
	public Donations getDonations(int id) {
		if(id == 4) {
			return donations;
		}
		return null;
	}
}
