package services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReciptProviderController {
    ReciptProviderBsl reciptProviderBsl;
	public ReciptProviderController() {
		
	}
    public ReciptProviderController(ReciptProviderBsl reciptProviderBsl) {
    	this.reciptProviderBsl = reciptProviderBsl ;
    }
	
	@GetMapping(value="/receipt/4")
	public QuarterlyReceipt getQuarterlyReceipt() {
		return reciptProviderBsl.getquarterlyReceipt();
	}
	@GetMapping(value="/receipt/1")
	public MonthlyReceipt getMonthlyReceipt() {
		return reciptProviderBsl.getmonthlyReceipt();
	}
	
}
