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
	
	
	@GetMapping(value="/serviceProvider/15")
	public We getServiceProviderWe() {
		return serviceProviderBsl.getWe();
	}
	@GetMapping(value="/serviceProvider/12")
	public Orange getServiceProviderOrange() {
		return serviceProviderBsl.getOrange();
	}
	@GetMapping(value="/serviceProvider/11")
	public Etisalat getServiceProviderEtisalat() {
		return serviceProviderBsl.getEtisalat();
	}
	@GetMapping(value="/serviceProvider/10")
	public Vodafone getServiceProviderVodafone() {
		return serviceProviderBsl.getVodafone();
	}

}