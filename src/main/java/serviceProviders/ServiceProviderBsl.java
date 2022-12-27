package serviceProviders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import refunds.RefundRequest;
import security.Authentication;

@Service
public class ServiceProviderBsl {
	ArrayList<ServiceProvider> serviceProviders;
	HashMap<Integer, String> hMap;
	public ServiceProviderBsl() {
		serviceProviders = new ArrayList<>();
		hMap = new HashMap<>();
	}
	public String addServiceProvider(ServiceProvider serviceProvider) {
		for(ServiceProvider serviceProviderDB : serviceProviders) {
			for(Integer i: hMap.keySet()) {
				if(serviceProviderDB.getId()==i) {
					return "This service provider already exists!";		
				}
			}
		}
		hMap.put(serviceProvider.getId(), serviceProvider.getName());
		serviceProviders.add(serviceProvider);
		return "Service provider: " +serviceProvider.getName()+ " added successfully!";
		
	}
	
	public ServiceProvider getServiceProvider(int id) {
		for(ServiceProvider serviceProviderDB : serviceProviders) {
				if(serviceProviderDB.getId()==id) {
					return serviceProviderDB;		
				}
			}
		return null;
	}
	
	
}
