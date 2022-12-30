package services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
@Service
public class DonationsController {
DonationsBsl donationsBsl;
	
	public  DonationsController() {
	
		this.donationsBsl = donationsBsl ;
	}

	@GetMapping(value="/serviceProvider/57357")
	public CancerHospital getServiceProviderWe() {
		return donationsBsl.getCancerHospital();
	}
	@GetMapping(value="/serviceProvider/10")
	public Schools getServiceProviderOrange() {
		return donationsBsl.getSchools();
	}
	@GetMapping(value="/serviceProvider/5")
	public NGOs getServiceProviderEtisalat() {
		return donationsBsl.getNGOs();
	}
	
}
