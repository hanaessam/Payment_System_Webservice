package services;

import org.springframework.stereotype.Component;

@Component
public class MonthlyReceipt implements ReciptProvider{
	 private int Id;
	    private String name;
	    private int totalTransactionAmount;
		
		public  MonthlyReceipt() {
			Id = 1;
			name = "monthly";
			totalTransactionAmount = 0;
		}
		
		public String getName() {
			return name;
		}

		public int getId() {
			return Id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setId(int Id) {
			this.Id = Id;
		}

		public int getTotalTransactionAmount() {
			return totalTransactionAmount;
		}

		public void setTotalTransactionAmount(int totalTransaction) {
			totalTransactionAmount = totalTransaction;
		}
}
