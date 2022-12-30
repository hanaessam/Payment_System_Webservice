package services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import discounts.Discount;
import discounts.DiscountDecorator;
import discounts.OverallDiscountBsl;
import discounts.SpecificDiscountBsl;
import payment.Cash;
import payment.CreditCard;
import payment.Wallet;

@RestController
public class ServiceController {
	ServiceBsl serviceBsl;
	static ServiceProviderBsl serviceProviderBsl ;
	Discount discount;
	static int transactionID = 0;
	
	public ServiceController(ServiceBsl serviceBsl) {
		this.serviceBsl = serviceBsl;
	}
	
//	@GetMapping(value="/service/mobileRecharge/{provider}")
//	public static MobileRecharge getMobileRecharge(@PathVariable("provider") String provider) {
//	//	serviceProviderBsl.addServiceProvider(provider);
//		  //ServiceBsl.getMobileRecharge().setServiceProviders(provider);
//		//serviceProviderBsl.addServiceProvider(provider);
//		return  ServiceBsl.getMobileRecharge();
//	}
	@GetMapping(value="/service/mobileRecharge")
	public static MobileRecharge getMobileRecharge() {
	
		return  ServiceBsl.getMobileRecharge();
	}
	
	@PostMapping(value="/service/mobileRecharge/payCredit/{providerId}")
	public String addRecharge(@RequestBody CreditCard creditCard, @PathVariable("providerId") int providerId) {
		creditCard.setAmountAfterDiscount(creditCard.getAmount());
		transactionID++;
		creditCard.setServiceName(ServiceBsl.getMobileRecharge().getName());
		if(ServiceBsl.getMobileRecharge().getSpecificDiscount() != 0) {
			discount = new SpecificDiscountBsl(discount);
			((DiscountDecorator)discount).percent = ServiceBsl.getMobileRecharge().getSpecificDiscount();
			creditCard.setAmountAfterDiscount( (int)discount.calculateDiscount(creditCard.getAmount()));
		}
		if(ServiceBsl.getMobileRecharge().getOverallDiscount() != 0) {
			discount = new OverallDiscountBsl(discount);
			((DiscountDecorator)discount).percent = ServiceBsl.getMobileRecharge().getOverallDiscount();
			creditCard.setAmountAfterDiscount( (int)discount.calculateDiscount(creditCard.getAmountAfterDiscount()));
		}
		if(!services.ServiceProviderBsl.check(providerId))
			return "Provider not found";
		return services.ServiceProviderBsl.transact(providerId, creditCard.getAmountAfterDiscount()) + payment.CreditCardBsl.calculatePayment(creditCard, transactionID);
	}
	
	@PostMapping(value="/service/mobileRecharge/payCash/{providerId}")
	public String addRecharge(@RequestBody Cash cash, @PathVariable("providerId") int providerId) {
		cash.setAmountAfterDiscount(cash.getAmount());
		transactionID++;
		cash.setServiceName(ServiceBsl.getMobileRecharge().getName());
		if(ServiceBsl.getMobileRecharge().getSpecificDiscount() != 0) {
			discount = new SpecificDiscountBsl(discount);
			((DiscountDecorator)discount).percent = ServiceBsl.getMobileRecharge().getSpecificDiscount();
			cash.setAmountAfterDiscount( (int)discount.calculateDiscount(cash.getAmount()));
		}
		if(ServiceBsl.getMobileRecharge().getOverallDiscount() != 0) {
			discount = new OverallDiscountBsl(discount);
			((DiscountDecorator)discount).percent = ServiceBsl.getMobileRecharge().getOverallDiscount();
			cash.setAmountAfterDiscount( (int)discount.calculateDiscount(cash.getAmountAfterDiscount()));
		}
		if(!services.ServiceProviderBsl.check(providerId))
			return "Provider not found";
		return services.ServiceProviderBsl.transact(providerId, cash.getAmountAfterDiscount()) + payment.CashBsl.calculatePayment(cash, transactionID);	
	}
	
	@PostMapping(value="/service/mobileRecharge/payWallet/{providerId}")
	public String addRecharge(@RequestBody Wallet wallet, @PathVariable("providerId") int providerId) {
		wallet.setAmountAfterDiscount(wallet.getAmount());
		transactionID++;
		wallet.setServiceName(ServiceBsl.getMobileRecharge().getName());
		if(ServiceBsl.getMobileRecharge().getSpecificDiscount() != 0) {
			discount = new SpecificDiscountBsl(discount);
			((DiscountDecorator)discount).percent = ServiceBsl.getMobileRecharge().getSpecificDiscount();
			wallet.setAmountAfterDiscount( (int)discount.calculateDiscount(wallet.getAmount()));
		}
		if(ServiceBsl.getMobileRecharge().getOverallDiscount() != 0) {
			discount = new OverallDiscountBsl(discount);
			((DiscountDecorator)discount).percent = ServiceBsl.getMobileRecharge().getOverallDiscount();
			wallet.setAmountAfterDiscount( (int)discount.calculateDiscount(wallet.getAmountAfterDiscount()));
		}
		if(!services.ServiceProviderBsl.check(providerId))
			return "Provider not found";
		
		return services.ServiceProviderBsl.transact(providerId, wallet.getAmountAfterDiscount()) + payment.WalletBsl.calculatePayment(wallet, transactionID);
	} 

//------------------------Internet Payment------------------------

	@GetMapping(value="/service/InternetPayment")
	public static InternetPayment getInternetPayment() {
		return  ServiceBsl.getInternetPayment();
	}
	
	@PostMapping(value="/service/InternetPayment/payCredit/{providerId}")
	public String addInternet(@RequestBody CreditCard creditCard, @PathVariable("providerId") int providerId) {
		creditCard.setAmountAfterDiscount(creditCard.getAmount());
		transactionID++;
		creditCard.setServiceName(ServiceBsl.getInternetPayment().getName());
		if(ServiceBsl.getInternetPayment().getSpecificDiscount() != 0) {
			discount = new SpecificDiscountBsl(discount);
			((DiscountDecorator)discount).percent = ServiceBsl.getInternetPayment().getSpecificDiscount();
			creditCard.setAmountAfterDiscount( (int)discount.calculateDiscount(creditCard.getAmount()));
		}
		if(ServiceBsl.getInternetPayment().getOverallDiscount() != 0) {
			discount = new OverallDiscountBsl(discount);
			((DiscountDecorator)discount).percent = ServiceBsl.getInternetPayment().getOverallDiscount();
			creditCard.setAmountAfterDiscount((int)discount.calculateDiscount(creditCard.getAmountAfterDiscount()));
		}
		if(!services.ServiceProviderBsl.check(providerId))
			return "Provider not found";
		
		return payment.CreditCardBsl.calculatePayment(creditCard, transactionID);
	}
	
	@PostMapping(value="/service/InternetPayment/payCash/{providerId}")
	public String addInternet(@RequestBody Cash cash , @PathVariable("providerId") int providerId) {
		cash.setAmountAfterDiscount(cash.getAmount());
		transactionID++;
		cash.setServiceName(ServiceBsl.getInternetPayment().getName());
		if(ServiceBsl.getInternetPayment().getSpecificDiscount() != 0) {
			discount = new SpecificDiscountBsl(discount);
			((DiscountDecorator)discount).percent = ServiceBsl.getInternetPayment().getSpecificDiscount();
			cash.setAmountAfterDiscount( (int)discount.calculateDiscount(cash.getAmount()));
		}
		if(ServiceBsl.getInternetPayment().getOverallDiscount() != 0) {
			discount = new OverallDiscountBsl(discount);
			((DiscountDecorator)discount).percent = ServiceBsl.getInternetPayment().getOverallDiscount();
			cash.setAmountAfterDiscount((int)discount.calculateDiscount(cash.getAmountAfterDiscount()));
		}
		if(!services.ServiceProviderBsl.check(providerId))
			return "Provider not found";
		return payment.CashBsl.calculatePayment(cash, transactionID);
	}
	
//	@PostMapping(value="/service/InternetPayment/payWallet")
//	public String addInternet(@RequestBody Wallet wallet) {
//		wallet.setAmountAfterDiscount(wallet.getAmount());
//		transactionID++;
//		wallet.setServiceName(ServiceBsl.getInternetPayment().getName());
//		return payment.WalletBsl.calculatePayment(wallet, transactionID);
//	}
	
//------------------------Landline------------------------

	@GetMapping(value="/service/Landline")
	public static LandLine getLandline() {
		return  ServiceBsl.getLandLine();
	}
		
//		@PostMapping(value="/service/Landline/payCredit/{providerId}")
//		public String addLandline(@RequestBody CreditCard creditCard , @PathVariable("providerId") int providerId) {
//			creditCard.setAmountAfterDiscount(creditCard.getAmount());
//			transactionID++;
//			creditCard.setServiceName(ServiceBsl.landLine.getName());
//			if(ServiceBsl.getLandLine().getSpecificDiscount() != 0) {
//				discount = new SpecificDiscountBsl(discount);
//				((DiscountDecorator)discount).percent = ServiceBsl.getLandLine().getSpecificDiscount();
//				creditCard.setAmountAfterDiscount( (int)discount.calculateDiscount(creditCard.getAmount()));
//			}
//			if(ServiceBsl.getLandLine().getOverallDiscount() != 0) {
//				discount = new OverallDiscountBsl(discount);
//				((DiscountDecorator)discount).percent = ServiceBsl.getLandLine().getOverallDiscount();
//				creditCard.setAmountAfterDiscount( (int)discount.calculateDiscount(creditCard.getAmountAfterDiscount()));
//			}
//			if(!services.ServiceProviderBsl.check(providerId))
//				return "Provider not found";
//			return payment.CreditCardBsl.calculatePayment(creditCard, transactionID);
//		}
		
		@PostMapping(value="/service/Landline/payCash/{providerId}")
		public String addLandline(@RequestBody Cash cash , @PathVariable("providerId") int providerId) {
			cash.setAmountAfterDiscount(cash.getAmount());
			transactionID++;
			cash.setServiceName(ServiceBsl.getLandLine().getName());
			if(ServiceBsl.getLandLine().getSpecificDiscount() != 0) {
				discount = new SpecificDiscountBsl(discount);
				((DiscountDecorator)discount).percent = ServiceBsl.getLandLine().getSpecificDiscount();
				cash.setAmountAfterDiscount( (int)discount.calculateDiscount(cash.getAmount()));
			}
			if(ServiceBsl.getLandLine().getOverallDiscount() != 0) {
				discount = new OverallDiscountBsl(discount);
				((DiscountDecorator)discount).percent = ServiceBsl.getLandLine().getOverallDiscount();
				cash.setAmountAfterDiscount( (int)discount.calculateDiscount(cash.getAmountAfterDiscount()));
			}
			if(!services.ServiceProviderBsl.check(providerId))
				return "Provider not found";

			return payment.CashBsl.calculatePayment(cash, transactionID);
		}
		
		@PostMapping(value="/service/Landline/payWallet/{providerId}")
		public String addLandline(@RequestBody Wallet wallet, @PathVariable("providerId") int providerId) {
			wallet.setAmountAfterDiscount(wallet.getAmount());
			transactionID++;
			wallet.setServiceName(ServiceBsl.getLandLine().getName());
			if(ServiceBsl.getLandLine().getSpecificDiscount() != 0) {
				discount = new SpecificDiscountBsl(discount);
				((DiscountDecorator)discount).percent = ServiceBsl.getLandLine().getSpecificDiscount();
				wallet.setAmountAfterDiscount( (int)discount.calculateDiscount(wallet.getAmount()));
			}
			if(ServiceBsl.getLandLine().getOverallDiscount() != 0) {
				discount = new OverallDiscountBsl(discount);
				((DiscountDecorator)discount).percent = ServiceBsl.getLandLine().getOverallDiscount();
                wallet.setAmountAfterDiscount( (int)discount.calculateDiscount(wallet.getAmountAfterDiscount()));
			}
			if(!services.ServiceProviderBsl.check(providerId))
				return "Provider not found";

			return payment.WalletBsl.calculatePayment(wallet, transactionID);
		}
		
//------------------------Donations------------------------

	@GetMapping(value="/service/Donations")
	public static Donations getDonations() {
		return  ServiceBsl.getDonations();
	}		
		
	@PostMapping(value="/service/Donations/payCredit/{providerId}")
	public String addDonation(@RequestBody CreditCard creditCard, @PathVariable("providerId") int providerId) {
		creditCard.setAmountAfterDiscount(creditCard.getAmount());
		transactionID++;
		creditCard.setServiceName(ServiceBsl.getDonations().getName());
		if(!services.ServiceProviderBsl.check(providerId))
			return "Provider not found";
		return payment.CreditCardBsl.calculatePayment(creditCard, transactionID);
	}

	@PostMapping(value="/service/Donations/payWallet/{providerId}")
	public String addDonation(@RequestBody Wallet wallet, @PathVariable("providerId") int providerId) {
		wallet.setAmountAfterDiscount(wallet.getAmount());
		transactionID++;
		wallet.setServiceName(ServiceBsl.getDonations().getName());
		if(!services.ServiceProviderBsl.check(providerId))
			return "Provider not found";
		return payment.WalletBsl.calculatePayment(wallet, transactionID);
	}
			
//	@PostMapping(value="/service/Donationst/payWallet")
//	public String addDonation(@RequestBody Wallet wallet) {
//		wallet.setAmountAfterDiscount(wallet.getAmount());
//		transactionID++;
//		wallet.setServiceName(ServiceBsl.getDonations().getName());
//		return payment.WalletBsl.calculatePayment(wallet, transactionID);
//	}
}