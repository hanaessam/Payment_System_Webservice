package services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceProviderController {
	ServiceProviderBsl serviceProviderBsl;
	
	public ServiceProviderController(ServiceProviderBsl serviceProviderBsl) {
		this.serviceProviderBsl = serviceProviderBsl;
	}
	
//	@PostMapping(value="/serviceProvider")
//	public String addNewServiceProvider(@RequestBody ServiceProvider serviceProvider) {
//		return serviceProviderBsl.addServiceProvider(serviceProvider);
//	}
	
	@GetMapping(value="/serviceProvider/015")
	public We getServiceProvider() {
		return serviceProviderBsl.getWe();
	}
//	@GetMapping(value="/serviceProvider/{name}")
//	public ServiceProvider searchServiceProvider(@PathVariable("name") String name) {
//		return serviceProviderBsl.getServiceProvider(name);
//	}
}