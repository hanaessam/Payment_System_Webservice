package services;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class We implements ServiceProvider{
    private Integer id;
    private String nameString;
	
	public We() {
		id = 15;
		nameString = "We";
	}
	
	@Override
	public String getName() {
		return nameString;
	}
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setName(String name) {
		nameString = name;
		
	}

	@Override
	public void setId(int Id) {
		id = Id;
	}
}