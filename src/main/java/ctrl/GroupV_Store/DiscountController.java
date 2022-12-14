package ctrl.GroupV_Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import models.Discount;
import models.Discount.discount_type;
import models.DiscountJdbcRepository;

@RestController
public class DiscountController {

	@Autowired
	DiscountJdbcRepository repository;

	@PostMapping("/discount/create")
	public int createDiscount(@RequestBody String data) throws Exception {
		Gson gson = new Gson();
		Discount newDiscount = gson.fromJson(data, Discount.class);
		String code = newDiscount.getCode();
		int discountAmount = newDiscount.getDiscount();
		int required_spending = newDiscount.getRequired_spending();
		discount_type type = newDiscount.getType();

		return repository.create(code, discountAmount, required_spending, type);
	}
}
