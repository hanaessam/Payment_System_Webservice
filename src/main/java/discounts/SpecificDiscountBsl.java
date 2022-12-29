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
	
	public float calculateDiscount(int price) {
		float result=price - (((float)(percent)/100 * price));
		return result;
	}
	public String addSpecificDiscount(SpecificDiscount specificDiscount) {
		for(SpecificDiscount specificDiscountDB : specificDiscounts) {
			if(specificDiscountDB.getDiscountId() == specificDiscount.getDiscountId()) {
				return"Discount ID already exist";
			}
		}
		for(Integer serviceId : specificDiscount.getServicesId()) {
			if(serviceId == 1) {
				services.ServiceController.getMobileRecharge().setSpecificDiscount(specificDiscount.getPercent());
			}
			else if(serviceId == 2) {
				services.ServiceController.getInternetPayment().setSpecificDiscount(specificDiscount.getPercent());
			}
			else if(serviceId == 3) {
				services.ServiceController.getLandline().setSpecificDiscount(specificDiscount.getPercent());
			}
			else if(serviceId == 4) {
				services.ServiceController.getDonations().setSpecificDiscount(specificDiscount.getPercent());
			}
			else {
				return "Service"+serviceId+" Id not found";
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