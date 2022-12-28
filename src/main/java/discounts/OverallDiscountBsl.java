package discounts;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import payment.CreditCard;

@Service
public class OverallDiscountBsl extends DiscountDecorator{
	ArrayList<OverallDiscount> overallDiscounts;
	
	public OverallDiscountBsl() {
//		super();
		overallDiscounts = new ArrayList<>();
	}
	
	public OverallDiscountBsl(Discount discount) {
		super(discount);
		this.discount = discount;
	}
	public float calculateDicount(int price) {
		float result= price - (((float)(percent)/100 * price));
		return result;
	}
	
	public String addOverallDiscount(OverallDiscount overallDiscount) {
		for(OverallDiscount overallDiscountDB : overallDiscounts) {
			if(overallDiscountDB.getDiscountId() == overallDiscount.getDiscountId()) {
				return"Discount ID already exist";
			}
		}
		overallDiscounts.add(overallDiscount);
		return"Overall discount is added successfully";
	}
	
	public OverallDiscount getOverallDiscount(int id) {
		for(OverallDiscount overallDiscountDB : overallDiscounts) {
			if(overallDiscountDB.getDiscountId() == id) {
				return overallDiscountDB;
			}
		}
		return null;
	}
	public CreditCard getCreditCard(int cardId) {
		for(CreditCard creditCardDB : getCreditCards()) {
			if(creditCardDB.getCardID() == cardId) {
				return creditCardDB;
			}
		}
		return null;
	}
}