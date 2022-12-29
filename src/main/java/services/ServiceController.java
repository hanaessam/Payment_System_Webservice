package services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import discounts.Discount;
import discounts.DiscountDecorator;
import discounts.OverallDiscount;
import discounts.OverallDiscountBsl;
import discounts.ServicePrice;
import discounts.SpecificDiscount;
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
	
	@PostMapping(value="/service/mobileRecharge/payCredit")
	public String addRecharge(@RequestBody CreditCard creditCard) {
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
		
		return payment.CreditCardBsl.calculatePayment(creditCard, transactionID);
	}
	
	@PostMapping(value="/service/mobileRecharge/payCash")
	public String addRecharge(@RequestBody Cash cash) {
		transactionID++;
		cash.setServiceName(ServiceBsl.getMobileRecharge().getName());
		return payment.CashBsl.calculatePayment(cash, transactionID);
	}
	
	@PostMapping(value="/service/mobileRecharge/payWallet")
	public String addRecharge(@RequestBody Wallet wallet) {
		transactionID++;
		wallet.setServiceName(ServiceBsl.getMobileRecharge().getName());
		return payment.WalletBsl.calculatePayment(wallet, transactionID);
	} 

//------------------------Internet Payment------------------------

	@GetMapping(value="/service/InternetPayment")
	public static InternetPayment getInternetPayment() {
		return  ServiceBsl.getInternetPayment();
	}
	
	@PostMapping(value="/service/InternetPayment/payCredit")
	public String addInternet(@RequestBody CreditCard creditCard) {
		creditCard.setAmountAfterDiscount(creditCard.getAmount());
		transactionID++;
		creditCard.setServiceName(ServiceBsl.internetPayment.getName());
		if(ServiceBsl.getInternetPayment().getSpecificDiscount() != 0) {
			discount = new SpecificDiscountBsl(discount);
			((DiscountDecorator)discount).percent = ServiceBsl.getInternetPayment().getSpecificDiscount();
			creditCard.setAmountAfterDiscount( (int)discount.calculateDiscount(creditCard.getAmount()));
		}
		if(ServiceBsl.getInternetPayment().getOverallDiscount() != 0) {
			discount = new OverallDiscountBsl(discount);
			((DiscountDecorator)discount).percent = ServiceBsl.getInternetPayment().getOverallDiscount();
			creditCard.setAmountAfterDiscount( (int)discount.calculateDiscount(creditCard.getAmountAfterDiscount()));
		}
		return payment.CreditCardBsl.calculatePayment(creditCard, transactionID);
	}
	
	@PostMapping(value="/service/InternetPayment/payCash")
	public String addInternet(@RequestBody Cash cash) {
		transactionID++;
		cash.setServiceName(ServiceBsl.getInternetPayment().getName());
		return payment.CashBsl.calculatePayment(cash, transactionID);
	}
	
	@PostMapping(value="/service/InternetPayment/payWallet")
	public String addInternet(@RequestBody Wallet wallet) {
		transactionID++;
		wallet.setServiceName(ServiceBsl.getInternetPayment().getName());
		return payment.WalletBsl.calculatePayment(wallet, transactionID);
	}
	
//------------------------Landline------------------------

	@GetMapping(value="/service/Landline")
	public static LandLine getLandline() {
		return  ServiceBsl.getLandLine();
	}
		
		@PostMapping(value="/service/Landline/payCredit")
		public String addLandline(@RequestBody CreditCard creditCard) {
			creditCard.setAmountAfterDiscount(creditCard.getAmount());
			transactionID++;
			creditCard.setServiceName(ServiceBsl.landLine.getName());
			if(ServiceBsl.getLandLine().getSpecificDiscount() != 0) {
				discount = new SpecificDiscountBsl(discount);
				((DiscountDecorator)discount).percent = ServiceBsl.getLandLine().getSpecificDiscount();
				creditCard.setAmountAfterDiscount( (int)discount.calculateDiscount(creditCard.getAmount()));
			}
			if(ServiceBsl.getLandLine().getOverallDiscount() != 0) {
				discount = new OverallDiscountBsl(discount);
				((DiscountDecorator)discount).percent = ServiceBsl.getLandLine().getOverallDiscount();
				creditCard.setAmountAfterDiscount( (int)discount.calculateDiscount(creditCard.getAmountAfterDiscount()));
			}
			return payment.CreditCardBsl.calculatePayment(creditCard, transactionID);
		}
		
		@PostMapping(value="/service/Landline/payCash")
		public String addLandline(@RequestBody Cash cash) {
			transactionID++;
			cash.setServiceName(ServiceBsl.getLandLine().getName());
			return payment.CashBsl.calculatePayment(cash, transactionID);
		}
		
		@PostMapping(value="/service/Landline/payWallet")
		public String addLandline(@RequestBody Wallet wallet) {
			transactionID++;
			wallet.setServiceName(ServiceBsl.getLandLine().getName());
			return payment.WalletBsl.calculatePayment(wallet, transactionID);
		}
		
		//------------------------Donations------------------------

		@GetMapping(value="/service/Donations")
		public static Donations getDonations() {
			return  ServiceBsl.getDonations();
		}
		
		
		
			@PostMapping(value="/service/Donations/payCredit")
			public String addDonation(@RequestBody CreditCard creditCard) {
				creditCard.setAmountAfterDiscount(creditCard.getAmount());
				transactionID++;
				creditCard.setServiceName(ServiceBsl.donations.getName());
				return payment.CreditCardBsl.calculatePayment(creditCard, transactionID);
			}
			
			@PostMapping(value="/service/Donations/payCash")
			public String addDonation(@RequestBody Cash cash) {
				transactionID++;
				cash.setServiceName(ServiceBsl.getDonations().getName());
				return payment.CashBsl.calculatePayment(cash, transactionID);
			}
			
			@PostMapping(value="/service/Donationst/payWallet")
			public String addDonation(@RequestBody Wallet wallet) {
				transactionID++;
				wallet.setServiceName(ServiceBsl.getDonations().getName());
				return payment.WalletBsl.calculatePayment(wallet, transactionID);
			}
	}