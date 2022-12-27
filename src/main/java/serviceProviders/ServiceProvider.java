package serviceProviders;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;


@Component
public class ServiceProvider {
	private int id;
	private String name;
	private ArrayList<String> paymentMethods;
	private boolean hasDiscount;
	public ServiceProvider() {
		this.id = id;
		this.name = name;
		paymentMethods = new ArrayList<>();
		this.hasDiscount = hasDiscount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getPaymentMethods() {
		return paymentMethods;
	}
	public void setPaymentMethods(ArrayList<String> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}
	public boolean isHasDiscount() {
		return hasDiscount;
	}
	public void setHasDiscount(boolean hasDiscount) {
		this.hasDiscount = hasDiscount;
	}
	
	
}
