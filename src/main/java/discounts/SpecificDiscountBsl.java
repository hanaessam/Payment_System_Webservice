package discounts;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class SpecificDiscountBsl extends DiscountDecorator{
	ArrayList<SpecificDiscount> specificDiscounts;
	
	public SpecificDiscountBsl() {
//		super();
		specificDiscounts = new ArrayList<>();
	}

	public SpecificDiscountBsl(Discount discount) {
		super(discount);
		this.discount = discount;
	}
	
	public float calculateDicount(int price) {
		float result=price - (((float)(percent)/100 * price));
		return result;
	}
	public String addSpecificDiscount(SpecificDiscount specificDiscount) {
		for(SpecificDiscount specificDiscountDB : specificDiscounts) {
			if(specificDiscountDB.getDiscountId() == specificDiscount.getDiscountId()) {
				return"Discount ID already exist";
			}
		}
		specificDiscounts.add(specificDiscount);
		return"Specific discount is added successfully";
	}
	
	public SpecificDiscount getSpecificDiscount(int id) {
		for(SpecificDiscount specificDiscountDB : specificDiscounts) {
			if(specificDiscountDB.getDiscountId() == id) {
				return specificDiscountDB;
			}
		}
		return null;
	}
}