package payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCardController {
	CreditCardBsl creditCardBsl;
	
	public CreditCardController(CreditCardBsl creditCardBsl) {
		this.creditCardBsl = creditCardBsl;
	}
	
	@PostMapping(value="/payment/creditcard")
	public String addCredit(@RequestBody CreditCard creditCard) {
		return creditCardBsl.addCreditCard(creditCard);
	}
	
	@GetMapping(value="/payment/creditcard/{id}")
	public CreditCard getCredit(@PathVariable("id") int id) {
		return creditCardBsl.getCreditCard(id);
	}
	@GetMapping(value="/payment/creditcard/check/{id}/{amount}")
	public String checkCredit(@PathVariable("id") int id, @PathVariable("amount") int amount) {
		return creditCardBsl.calculatePayment(id, amount);
	}
	@PutMapping(value="/payment/creditcard/addToWallet/{id}/{funds}")
	public String addToWallet(@PathVariable("id") int id, @PathVariable("funds") int funds) {
		return creditCardBsl.addToWallet(id, funds);
	}
}