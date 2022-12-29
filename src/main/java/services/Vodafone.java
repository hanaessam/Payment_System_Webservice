package services;

import org.springframework.stereotype.Component;

@Component
public class Vodafone implements ServiceProvider{
	private int Id;
	private String name;
	public Vodafone() {
		Id = 10;
		name = "Vodafone";
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getId() {
		return Id;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		
	}

	@Override
	public void setId(int Id) {
		this.Id = Id;
	}
	
}