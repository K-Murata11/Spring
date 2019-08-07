package jp_co.good_works.lesson.springmvc.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


public class ProductForm {
@NotEmpty
private String name;

@NotNull
@Min(value = 0) @Max(value = 999999) 
private Integer price;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
}
