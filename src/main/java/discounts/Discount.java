package discounts;

import org.springframework.stereotype.Service;

@Service
public interface Discount {
	public float calculateDiscount(int price);
}