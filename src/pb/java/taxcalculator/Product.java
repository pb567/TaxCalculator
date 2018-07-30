package pb.java.taxcalculator;

// Product information

import java.util.regex.Pattern;

public class Product {
	private String desc;
	private Double price;
	private Boolean dutyProduct = false;
	private Boolean taxExempt = false;
	private Double taxedPrice;
	private int quantity;

	public Product(int quantity, String desc, Double price) {
		this.quantity = quantity;
		this.desc = desc;
		this.price = price;
		tagTaxStatus(desc);
	}

	public int getQuantity() {
		return this.quantity;
	}

	public String getDescription() {
		return this.desc;
	}

	public Double getPrice() {
		return this.price;
	}

	public Boolean taxExempt() {
		return this.taxExempt;
	}

	public Boolean dutyProduct() {
		return this.dutyProduct;
	}

	public Double setTaxedPrice(Double amount) {
		return this.taxedPrice = amount;
	}

	public Double getTaxedPrice() {
		return this.taxedPrice;
	}

	private void tagTaxStatus(String desc) {
		Pattern exemptProducts = Pattern.compile("pills|chocolate|book|wine");
		Pattern dutyProducts = Pattern.compile("imported");
		if (exemptProducts.matcher(desc).find()) {
			this.taxExempt = true;
		}

		if (dutyProducts.matcher(desc).find()) {
			this.dutyProduct = true;
		}
	}
}
