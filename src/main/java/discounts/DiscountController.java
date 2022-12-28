package discounts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscountController {
	SpecificDiscountBsl specificDiscountBsl;
	OverallDiscountBsl overallDiscountBsl;
	
	public DiscountController(SpecificDiscountBsl specificDiscountBsl, OverallDiscountBsl overallDiscountBsl) {
		this.specificDiscountBsl = specificDiscountBsl;
		this.overallDiscountBsl = overallDiscountBsl;
	}
	
	@PostMapping(value="/discount/overall")
	public String addOverallDiscount(@RequestBody OverallDiscount overallDiscount) {
		return overallDiscountBsl.addOverallDiscount(overallDiscount);
	}
	@PostMapping(value="/discount/specific")
	public String addSpecificDiscount(@RequestBody SpecificDiscount specificDiscount) {
		return specificDiscountBsl.addSpecificDiscount(specificDiscount);
	}
	
	@GetMapping(value="/discount/overall{discountId}")
	public OverallDiscount getOverallDiscount(@PathVariable("discountId") int discountId) {
		return overallDiscountBsl.getOverallDiscount(discountId);
	}
	
	@GetMapping(value="/discount/specific{discountId}")
	public SpecificDiscount getSpecificDiscount(@PathVariable("discountId") int discountId) {
		return specificDiscountBsl.getSpecificDiscount(discountId);
	}
}