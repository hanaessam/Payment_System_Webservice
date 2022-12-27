package discounts;

public class OverallDiscountBsl {
	
	
	
	public String addDiscount(int price , int percent) { 
		float result= price - (((float)(percent)/100 * price));
		return "discount added successfully";
	}
	
	
	public float getDiscount(int price, int ) {
		float result= price - (((float)(percent)/100 * price));
		return result;
	}
}
