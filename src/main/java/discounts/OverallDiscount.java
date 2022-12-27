package discounts;

public class OverallDiscount extends DiscountDecorator{
	private int price;
	private int percent;
	
	public OverallDiscount(Discount discount) {
		super(discount);
		this.discount = discount;
	}

	@Override
	public String addDiscount(int price) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}