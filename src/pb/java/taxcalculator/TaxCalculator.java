package pb.java.taxcalculator;

// To calculate sales tax and totals

import java.util.List;

public class TaxCalculator {
	private Double totalTax = 0.00;
	private Double totalSale = 0.00;
	private Double totalProductPrice = 0.00;

	public TaxCalculator(List<Product> products) {
		for (Product product : products) {
			this.totalProductPrice = this.totalProductPrice
					+ (product.getPrice() * product.getQuantity());
			this.totalTax = this.totalTax + calculateSalesTax(product);
		}
		this.totalSale = this.totalProductPrice + this.totalTax;
	}

	private Double calculateSalesTax(Product product) {
		Double tax = .10;
		if (product.taxExempt()) {
			tax = .00;
		}

		if (product.dutyProduct()) {
			tax = tax + .05;
		}
		Double rounded = roundAmount((product.getPrice() * tax)
				* product.getQuantity());
		product.setTaxedPrice(rounded
				+ (product.getPrice() * product.getQuantity()));
		return rounded;
	}

	public Double getTotalTax() {
		return this.totalTax;
	}

	public Double getTotalSale() {
		return this.totalSale;
	}

	private Double roundAmount(Double amount) {
		return Math.ceil((amount * 20.0)) / 20.0;
	}
}
