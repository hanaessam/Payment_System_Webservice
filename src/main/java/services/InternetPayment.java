package services;

import org.springframework.stereotype.Component;

@Component
public class InternetPayment implements Service{
	private int serviceId;
	private String name ;
	private String[] paymentMethods = {"credit","cash"};
	private int overallDiscount = 0;
	private int specificDiscount = 0;
	
	public InternetPayment() {
		super();
		this.serviceId = 2;
		this.name = "Internet Payment";
		this.overallDiscount = 0;
		this.specificDiscount = 0;
	}

	public InternetPayment(int serviceId, String name, String[] paymentMethods, int overallDiscount,int specificDiscount) {
		super();
		this.serviceId = serviceId;
		this.name = name;
		this.paymentMethods = paymentMethods;
		this.overallDiscount = overallDiscount;
		this.specificDiscount = specificDiscount;
	}

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
	public String[] getPaymentMethods() {
		return paymentMethods;
	}
	public void setPaymentMethods(String[] paymentMethods) {
		this.paymentMethods = paymentMethods;
	}
	public int getOverallDiscount() {
		return overallDiscount;
	}
	public void setOverallDiscount(int overallDiscount) {
		this.overallDiscount = overallDiscount;
	}
	public int getSpecificDiscount() {
		return specificDiscount;
	}
	public void setSpecificDiscount(int specificDiscount) {
		this.specificDiscount = specificDiscount;
	}
}