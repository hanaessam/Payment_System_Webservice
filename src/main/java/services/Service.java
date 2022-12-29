package services;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public interface Service {
//	private int serviceId;
//	private String name;
//	private ArrayList<String> paymentMethods;
//	private static int overallDiscount = 0;
//	private static int specificDiscount = 0;
//	
//	public int getServiceId() {
//		return serviceId;
//	}
//	public void setServiceId(int serviceId) {
//		this.serviceId = serviceId;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public ArrayList<String> getPaymentMethods() {
//		return paymentMethods;
//	}
//	public void setPaymentMethods(ArrayList<String> paymentMethods) {
//		this.paymentMethods = paymentMethods;
//	}
//	public static int getOverallDiscount() {
//		return overallDiscount;
//	}
//	public static void setOverallDiscount(int overallDiscount) {
//		Service.overallDiscount = overallDiscount;
//	}
//	public static int getSpecificDiscount() {
//		return specificDiscount;
//	}
//	public static void setSpecificDiscount(int specificDiscount) {
//		Service.specificDiscount = specificDiscount;
//	}
	public int getServiceId();
	public void setServiceId(int serviceId);
	public String getName();
	public void setName(String name);
	public String[] getPaymentMethods();
	public void setPaymentMethods(String[] paymentMethods);
	public int getOverallDiscount();
	public void setOverallDiscount(int overallDiscount);
	public int getSpecificDiscount();
	public void setSpecificDiscount(int specificDiscount);
}