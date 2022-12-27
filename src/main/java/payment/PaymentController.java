package payment;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import Users.User;

@RestController
public class PaymentController {
	CreditCardBsl creditCardBsl;
	WalletBsl walletBsl;
	CashBsl cashBsl;
	User user;
	static int transactionID=0;
	
	public PaymentController(CreditCardBsl creditCardBsl, WalletBsl walletBsl, CashBsl cashBsl) {
		this.creditCardBsl = creditCardBsl;
		this.walletBsl = walletBsl;
		this.cashBsl = cashBsl;
	}
	
	@GetMapping(value="/payment/creditcard/listTransactions")
	public ArrayList<CreditCard> listCreditTransactions() {
		return creditCardBsl.getCreditCards();
	}
	@GetMapping(value="/payment/cash/listTransactions")
	public ArrayList<Cash> listCashTransactions() {
		return cashBsl.cash;
	}
	@GetMapping(value="/payment/walet/listTransactions")
	public ArrayList<Wallet> listWalletTransactions() {
		return walletBsl.wallets;
	}
	
	@GetMapping(value="/payment/creditcard/{cardId}")
	public CreditCard getCredit(@PathVariable("cardId") int cardId) {
		return creditCardBsl.getCreditCard(cardId);
	}
	
	@GetMapping(value="/payment/wallet/{UserID}")
	public Wallet getWallet(@PathVariable ("UserID") int userId) {
		return walletBsl.getWallet(userId);
	}

	@PutMapping(value="/payment/creditcard/addToWallet/{id}/{funds}")
	public String addToWallet(@PathVariable("id") int id, @PathVariable("funds") int funds) {
		return creditCardBsl.addToWallet(id, funds);
	}
	@PostMapping(value="/payment/creditcard")
	public String payCredit(@RequestBody CreditCard creditCard) {
		transactionID++;
		return creditCardBsl.calculatePayment(creditCard, transactionID);
	}
	@PostMapping(value="/payment/cash")
	public String payCash(@RequestBody Cash cash) {
		transactionID++;
		return cashBsl.calculatePayment(cash, transactionID);
	}
	@PostMapping(value="/payment/wallet")
	public String payWallet(@RequestBody Wallet wallet) {
		transactionID++;
		return walletBsl.calculatePayment(wallet, transactionID);
	}
}