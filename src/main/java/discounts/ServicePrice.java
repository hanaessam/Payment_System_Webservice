package discounts;

import org.springframework.stereotype.Service;

@Service
public class ServicePrice implements Discount {
	public static int servicePrice;
	public ServicePrice() {
		this.servicePrice = 0;
	}
	public ServicePrice(int servicePrice) {
		this.servicePrice = servicePrice;
	}
	public float calculateDicount(int price) {
		return price;
	}
}