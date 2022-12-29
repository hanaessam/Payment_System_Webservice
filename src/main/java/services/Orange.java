package services;

import org.springframework.stereotype.Component;

@Component
public class Orange implements ServiceProvider{

	private int Id;
	private String name;
	public Orange() {
		Id = 12;
		name = "Orange";
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