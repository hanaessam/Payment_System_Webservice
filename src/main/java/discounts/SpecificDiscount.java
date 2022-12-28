package discounts;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class SpecificDiscount{
	private int percent;
	private int discountId;
	private ArrayList<Integer> servicesId;
	
	public SpecificDiscount() {
		this.percent = 0;
		this.discountId = 0;
		this.servicesId = new ArrayList<>();
	}
	
	public SpecificDiscount(int percent, int discountId, ArrayList<Integer> servicesId) {
		this.percent = percent;
		this.discountId = discountId;
		this.servicesId = servicesId;
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
	public ArrayList<Integer> getServicesId() {
		return servicesId;
	}
	public void setServicesId(ArrayList<Integer> servicesId) {
		this.servicesId = servicesId;
	}
}
