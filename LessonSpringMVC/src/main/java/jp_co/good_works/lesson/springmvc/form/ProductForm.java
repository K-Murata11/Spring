package jp_co.good_works.lesson.springmvc.form;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

public class ProductForm{
	
	@NotEmpty
	private String name;
	
	@NotNull
	@Min(value = 10)
	@Max(value = 10000)
	private Integer price;
	
	public void setName (String name) {
		this.name = name;
	}
	public String getName () {
		return name;
	}
	public void setPrice (Integer price) {
		this.price = price;
	}
	public Integer getPrice () {
		return price;
	}
}
