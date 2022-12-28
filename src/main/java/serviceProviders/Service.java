package serviceProviders;

import java.util.ArrayList;

public class Service {
	private int serviceId;
	private String name;
	private ArrayList<String> paymentMethods;
	private static int overallDiscount = 0;
	private static int specificDiscount = 0;
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
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
	public static int getOverallDiscount() {
		return overallDiscount;
	}
	public static void setOverallDiscount(int overallDiscount) {
		Service.overallDiscount = overallDiscount;
	}
	public static int getSpecificDiscount() {
		return specificDiscount;
	}
	public static void setSpecificDiscount(int specificDiscount) {
		Service.specificDiscount = specificDiscount;
	}
}