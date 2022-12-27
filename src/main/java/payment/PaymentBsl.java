package payment;

import org.springframework.stereotype.Service;

@Service
public interface PaymentBsl {
	public String calculatePayment(int id, int amount);
}