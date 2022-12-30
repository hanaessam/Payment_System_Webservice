package services;

import org.springframework.stereotype.Component;

@Component
public interface ReciptProvider {
	public String getName();
	public int getId();
	public void setName(String name);
	public void setId(int Id);
}
