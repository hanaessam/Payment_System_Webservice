package discounts;

import org.springframework.stereotype.Component;

@Component
public class OverallDiscount{
	private int percent;
	private int discountId;
	
	public OverallDiscount() {
		this.percent = percent;
		this.discountId = discountId;
	}
	
	public OverallDiscount(int percent, int discountId) {
		this.percent = percent;
		this.discountId = discountId;
	}

	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	public int getDiscountId() {
		return discountId;
	}
	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}
}