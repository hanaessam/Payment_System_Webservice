package services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;


@Service
public class ServiceProviderBsl {
    static We we;
	static Vodafone vodafone;
	static Etisalat etisalat;
	static Orange orange;

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
	
//	public String addServiceProvider(ServiceProvider serviceProvider) {
//		for(ServiceProvider serviceProviderDB : serviceProviders) {
//			if(serviceProviderDB.getName().equals(serviceProvider.getName())) {
//					return "This service provider already exists!";	
//			}
//		}
//		serviceProviders.add(serviceProvider);
//		return "Service provider: " +serviceProvider.getName()+ " added successfully!";
//	}
//	
//	public We getServiceProvider(int id) {
//		if(id == 015) {
//			return we;
//		}
//		return null;
//	}
////	public ServiceProvider getServiceProvider(String name) {
////		for(ServiceProvider serviceProviderDB : serviceProviders) {
////				if(serviceProviderDB.getName().equals(name)) {
////					return serviceProviderDB;		
////				}
////			}
////		return null;
////	}
	
	
}