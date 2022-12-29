package services;

import java.util.ArrayList;

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
	
//	public  String addServiceProvider(String name) {
//		if(name== "we") {
//			serviceProviders.add(we);
//		
//		}
//		if(name== "etisalt") {
//			serviceProviders.add(etisalat);
//		
//		}
//		if(name== "vodafone") {
//			serviceProviders.add(vodafone);
//		
//		}
//		if(name== "orange") {
//			serviceProviders.add(orange);
//			
//		}
//		return name;
//	}
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