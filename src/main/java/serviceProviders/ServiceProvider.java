package serviceProviders;

import org.springframework.stereotype.Component;

@Component
public class ServiceProvider {
	private String name;
	private int providerId;
	
	public ServiceProvider() {
	this.name = name;
	this.providerId = providerId;
	}
	public ServiceProvider(String name, int providerId) {
		this.name = name;
		this.providerId = providerId;
	}
	
	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}