package discounts;

public class OverallDiscount extends DiscountDecorator{
	private int price;
	private int percent;
	
	public OverallDiscount(Discount discount) {
		super(discount);
		this.discount = discount;
	}
	
	
}