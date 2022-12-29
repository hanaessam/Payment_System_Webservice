package services;

import payment.Payment;

public class MobileRecharge implements Service{
//	Payment payment;
//	ServiceProvider serviceProvider;
//	public MobileRecharge(Payment payment, ServiceProvider serviceProvider) {
//		this.payment = payment;
//		this.serviceProvider = serviceProvider;
//	}
	private int serviceId;
	private String name ;
	private String[] paymentMethods = {"credit","cash"};
	private int overallDiscount = 0;
	private int specificDiscount = 0;
	private static int userId;
	private static int amount;
	
	
	public MobileRecharge() {
		super();
		this.serviceId = 1;
		this.name = "MobileRecharge";
		this.overallDiscount = 0;
		this.specificDiscount = 0;
		this.userId = userId;
		this.amount = amount;
	}

	public MobileRecharge(int userId, int serviceId, String name, String[] paymentMethods, int overallDiscount,int specificDiscount, int amount) {
		super();
		this.userId = userId;
		this.serviceId = serviceId;
		this.name = name;
		this.paymentMethods = paymentMethods;
		this.overallDiscount = overallDiscount;
		this.specificDiscount = specificDiscount;
		this.amount = amount;
	}
	
	

	public static int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public  int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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