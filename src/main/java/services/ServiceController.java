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
		if(payment.CreditCardBsl.calculatePayment(creditCard, transactionID)=="User not found." || payment.CreditCardBsl.calculatePayment(creditCard, transactionID) == "Not enough credit")
			return payment.CreditCardBsl.calculatePayment(creditCard, transactionID);
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
		if(payment.CashBsl.calculatePayment(cash, transactionID)=="User not found.")
			return payment.CashBsl.calculatePayment(cash, transactionID);
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
		if(payment.WalletBsl.calculatePayment(wallet, transactionID)=="User not found." || payment.WalletBsl.calculatePayment(wallet, transactionID) == "Not enough points in wallet")
			return payment.WalletBsl.calculatePayment(wallet, transactionID);
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
		if(payment.CreditCardBsl.calculatePayment(creditCard, transactionID)=="User not found." || payment.CreditCardBsl.calculatePayment(creditCard, transactionID) == "Not enough credit")
			return payment.CreditCardBsl.calculatePayment(creditCard, transactionID);
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
		if(payment.CashBsl.calculatePayment(cash, transactionID)=="User not found.")
			return payment.CashBsl.calculatePayment(cash, transactionID);
		return payment.CashBsl.calculatePayment(cash, transactionID);
	}
	

	
//------------------------Landline------------------------

	@GetMapping(value="/service/Landline")
	public static LandLine getLandline() {
		return  ServiceBsl.getLandLine();
	}
	
	@PostMapping(value="/service/Landline/payCreditCard/{receiptId}")
	public String addLandline(@RequestBody CreditCard creditCard , @PathVariable("receiptId") int receiptId) {
		creditCard.setAmountAfterDiscount(creditCard.getAmount());
		transactionID++;
		creditCard.setServiceName(ServiceBsl.getLandLine().getName());
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
		if(!services.ReciptProviderBsl.check(receiptId))
			return "Provider not found";
		if(payment.CreditCardBsl.calculatePayment(creditCard, transactionID)=="User not found.")
			return payment.CreditCardBsl.calculatePayment(creditCard, transactionID);
		return services.ReciptProviderBsl.transact(receiptId, creditCard.getAmountAfterDiscount()) + payment.CreditCardBsl.calculatePayment(creditCard, transactionID);	
	}

		@PostMapping(value="/service/Landline/payCash/{receiptId}")
		public String addLandline(@RequestBody Cash cash , @PathVariable("receiptId") int receiptId) {
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
			if(!services.ReciptProviderBsl.check(receiptId))
				return "Provider not found";
			if(payment.CashBsl.calculatePayment(cash, transactionID)=="User not found.")
				return payment.CashBsl.calculatePayment(cash, transactionID);
			return services.ReciptProviderBsl.transact(receiptId, cash.getAmountAfterDiscount()) + payment.CashBsl.calculatePayment(cash, transactionID);	
		}
		
		@PostMapping(value="/service/Landline/payWallet/{receiptId}")
		public String addLandline(@RequestBody Wallet wallet, @PathVariable("receiptId") int receiptId) {
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
			if(!services.ReciptProviderBsl.check(receiptId))
				return "Provider not found";
			if(payment.WalletBsl.calculatePayment(wallet, transactionID)=="User not found." || payment.WalletBsl.calculatePayment(wallet, transactionID) == "Not enough points in wallet")
				return payment.WalletBsl.calculatePayment(wallet, transactionID);

			return services.ReciptProviderBsl.transact(receiptId, wallet.getAmountAfterDiscount()) + payment.WalletBsl.calculatePayment(wallet, transactionID);	 
		}
		
//------------------------Donations------------------------

	@GetMapping(value="/service/Donations")
	public static Donations getDonations() {
		return  ServiceBsl.getDonations();
	}		
		
	@PostMapping(value="/service/Donations/payCredit/{orgId}")
	public String addDonation(@RequestBody CreditCard creditCard, @PathVariable("orgId") int orgId) {
		creditCard.setAmountAfterDiscount(creditCard.getAmount());
		transactionID++;
		creditCard.setServiceName(ServiceBsl.getDonations().getName());
		if(!services.DonationsBsl.check(orgId))
			return "Orgnization not found";
		if(payment.CreditCardBsl.calculatePayment(creditCard, transactionID)=="User not found." || payment.CreditCardBsl.calculatePayment(creditCard, transactionID) == "Not enough credit")
			return payment.CreditCardBsl.calculatePayment(creditCard, transactionID);
		return services.DonationsBsl.transact(orgId, creditCard.getAmountAfterDiscount()) + payment.CreditCardBsl.calculatePayment(creditCard, transactionID);	 
	}

	@PostMapping(value="/service/Donations/payWallet/{orgId}")
	public String addDonation(@RequestBody Wallet wallet, @PathVariable("orgId") int orgId) {
		wallet.setAmountAfterDiscount(wallet.getAmount());
		transactionID++;
		wallet.setServiceName(ServiceBsl.getDonations().getName());
		if(!services.DonationsBsl.check(orgId))
			return "Orgnization not found";
		if(payment.WalletBsl.calculatePayment(wallet, transactionID)=="User not found." || payment.WalletBsl.calculatePayment(wallet, transactionID) == "Not enough points in wallet")
			return payment.WalletBsl.calculatePayment(wallet, transactionID);
		return services.DonationsBsl.transact(orgId, wallet.getAmountAfterDiscount()) + payment.WalletBsl.calculatePayment(wallet, transactionID);	 
	}
			

}