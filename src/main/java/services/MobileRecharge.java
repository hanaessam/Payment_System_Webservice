package services;

import payment.Payment;

public class MobileRecharge extends Service{
	Payment payment;
	ServiceProvider serviceProvider;
	public MobileRecharge(Payment payment, ServiceProvider serviceProvider) {
		super();
		this.payment = payment;
		this.serviceProvider = serviceProvider;
	}
	
}