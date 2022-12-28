package services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;


@Service
public class ServiceProviderBsl {
	ArrayList<ServiceProvider> serviceProviders;
	public ServiceProviderBsl() {
		serviceProviders = new ArrayList<>();
	}
	public String addServiceProvider(ServiceProvider serviceProvider) {
		for(ServiceProvider serviceProviderDB : serviceProviders) {
			if(serviceProviderDB.getName().equals(serviceProvider.getName())) {
					return "This service provider already exists!";	
			}
		}
		serviceProviders.add(serviceProvider);
		return "Service provider: " +serviceProvider.getName()+ " added successfully!";
	}
	
	public ServiceProvider getServiceProvider(int id) {
		for(ServiceProvider serviceProviderDB : serviceProviders) {
				if(serviceProviderDB.getProviderId()==id) {
					return serviceProviderDB;		
				}
			}
		return null;
	}
	public ServiceProvider getServiceProvider(String name) {
		for(ServiceProvider serviceProviderDB : serviceProviders) {
				if(serviceProviderDB.getName().equals(name)) {
					return serviceProviderDB;		
				}
			}
		return null;
	}
}