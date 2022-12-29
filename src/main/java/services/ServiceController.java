package services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import payment.Cash;
import payment.CreditCard;
import payment.Wallet;

@RestController
public class ServiceController {
	ServiceBsl serviceBsl;
	static int transactionID = 0;
	
	public ServiceController(ServiceBsl serviceBsl) {
		this.serviceBsl = serviceBsl;
	}
		
	@GetMapping(value="/service/mobileRecharge")
	public MobileRecharge getMobileRecharge() {
		return  ServiceBsl.getMobileRecharge();
	}
	
	@PostMapping(value="/service/mobileRecharge/payCredit")
	public String addRecharge(@RequestBody CreditCard creditCard) {
		transactionID++;
		creditCard.setServiceName(ServiceBsl.getMobileRecharge().getName());
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
}