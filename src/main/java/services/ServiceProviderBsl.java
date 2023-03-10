package services;

import org.springframework.stereotype.Service;


@Service
public class ServiceProviderBsl {
    static We we;
	static Vodafone vodafone;
	static Etisalat etisalat;
	static Orange orange;
//	static ArrayList<ServiceProvider> serviceProviders;
//	public  ArrayList<ServiceProvider> getServiceProviders() {
//		return serviceProviders;
//	}
//
//	public  void setServiceProviders(ArrayList<ServiceProvider> serviceProviders) {
//	         serviceProviders = serviceProviders;
//	}

	public ServiceProviderBsl() {
		we = new We();
		vodafone = new Vodafone();
		etisalat = new Etisalat();
		orange = new Orange();
	}
	
	public static We getWe() {
		return we;
	}
	public static Vodafone getVodafone() {
		return vodafone;
	}
	public static Etisalat getEtisalat() {
		return etisalat;
	}
	public static Orange getOrange() {
		return orange;
	}
	
	public static String transact(int providerId, int amount) {
		if(providerId == 15) {
			we.setTotalTransactionAmount(we.getTotalTransactionAmount() + amount);
			return "WE SERVICE PROVIDER\n" ;
		}
		else if(providerId == 11){
			etisalat.setTotalTransactionAmount(etisalat.getTotalTransactionAmount() + amount);
			return "ETISALAT SERVICE PROVIDER\n" ;
		}
		else if(providerId == 10){
			vodafone.setTotalTransactionAmount(vodafone.getTotalTransactionAmount() + amount);
			return "VODAFONE SERVICE PROVIDER\n" ;
		}
		else if(providerId == 12){
			orange.setTotalTransactionAmount(orange.getTotalTransactionAmount() + amount);
			return "ORANGE SERVICE PROVIDER\n" ;
		}
		else {
			return "Provider not found";
		}
	}

	public static boolean check(int providerId) {
		if(providerId==11 || providerId==10 ||providerId==15 ||providerId==12) {
			return true;
		}
		return false;
	}
	

}