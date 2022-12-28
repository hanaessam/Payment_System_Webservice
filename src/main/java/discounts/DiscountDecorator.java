package discounts;

import org.springframework.stereotype.Service;

@Service
public abstract class DiscountDecorator implements Discount {
	public static Discount discount;
	public static int percent;
	public DiscountDecorator() {
		
	}
	public DiscountDecorator(Discount discount) {
		this.discount=discount;
	}
}