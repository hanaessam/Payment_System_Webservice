package services;

import org.springframework.stereotype.Component;

@Component
public interface Service {
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