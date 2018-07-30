package pb.java.taxcalculator;

import pb.java.taxcalculator.Product;

public class ReceiptPrinter {
	private String productFormat = "%1$-40s %2$6.2f %n";
	private String taxFormat = "%1$40s %2$6.2f %n";
	private String totalFormat = "%1$40s %2$6.2f %n%n%n";

	public void purchaseList(Product product) {
		System.out.format(productFormat, product.getQuantity() + " " + product.getDescription() + ": ",
				product.getTaxedPrice());
	}

	public void taxes(Double totalTax) {
		System.out.format(taxFormat, "Sales Taxes:", totalTax);
	}

	public void totalSale(Double totalSale) {
		System.out.format(totalFormat, "Total:", totalSale);
	}

	public void lineBreak() {
		String dashes = new String(new char[48]).replace("\0", "-");
		System.out.format(dashes + "%n");
	}
}
