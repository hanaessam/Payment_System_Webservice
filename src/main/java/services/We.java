package services;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class We implements ServiceProvider{
    private int Id;
    private String name;
    private int totalTransactionAmount;
	
	public We() {
		Id = 15;
		name = "We";
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