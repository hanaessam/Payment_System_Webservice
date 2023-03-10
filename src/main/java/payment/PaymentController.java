package payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	static CreditCardBsl creditCardBsl;
	static WalletBsl walletBsl;
	static CashBsl cashBsl;
	
	public PaymentController(CreditCardBsl creditCardBsl, WalletBsl walletBsl, CashBsl cashBsl) {
		this.creditCardBsl = creditCardBsl;
		this.walletBsl = walletBsl;
		this.cashBsl = cashBsl;
	}
	
	@GetMapping(value="/payment/creditcard/listTransactions")
	public static ArrayList<CreditCard> listCreditTransactions() {
		return creditCardBsl.getCreditCards();
	}
	@GetMapping(value="/payment/cash/listTransactions")
	public static ArrayList<Cash> listCashTransactions() {
		return cashBsl.getCashs();
	}
	@GetMapping(value="/payment/walet/listTransactions")
	public static ArrayList<Wallet> listWalletTransactions() {
		return walletBsl.getWallets();
	}
	
	@GetMapping(value="/walet/listAddToWalletTransactions")
	public static Vector<HashMap<String, Integer>> listAddToWalletWalletTransactions() {
		return creditCardBsl.getAddToWalletTransactions();
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
	

}