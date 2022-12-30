package discounts;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

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
	public float calculateDiscount(int price) {
		float result= price - (((float)(percent)/100 * price));
		return result;
	}
	
	public String addOverallDiscount(OverallDiscount overallDiscount) {
		for(OverallDiscount overallDiscountDB : overallDiscounts) {
			if(overallDiscountDB.getDiscountId() == overallDiscount.getDiscountId()) {
				return"Discount ID already exist";
			}
		}
		services.ServiceController.getMobileRecharge().setOverallDiscount(overallDiscount.getPercent());
		services.ServiceController.getInternetPayment() .setOverallDiscount(overallDiscount.getPercent());
		services.ServiceController.getLandline().setOverallDiscount(overallDiscount.getPercent());
		overallDiscounts.add(overallDiscount);
		return"Overall discount is added successfully";
	}
	
	public OverallDiscount getOverallDiscount(int id) {
		for(OverallDiscount overallDiscountDB : getOverallDiscounts()) {
			if(overallDiscountDB.getDiscountId() == id) {
				return overallDiscountDB;
			}
		}
		return null;
	}
	

	public ArrayList<OverallDiscount> getOverallDiscounts() {
		return overallDiscounts;
	}

	public void setOverallDiscounts(ArrayList<OverallDiscount> overallDiscounts) {
		this.overallDiscounts = overallDiscounts;
	}
	}