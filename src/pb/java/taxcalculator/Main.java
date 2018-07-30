package pb.java.taxcalculator;

// Controller class

import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		String[] carts = { "input/cart1.txt", "input/cart2.txt", "input/cart3.txt" };

		for (String cart : carts) {
			if (new File(cart).exists()) {
				CartScanner scanner = new CartScanner(cart);
				Cart purchaseCart = scanner.getPurchaseCart();
				TaxCalculator calc = new TaxCalculator(purchaseCart.getPurchaseItems());
				ReceiptPrinter printer = new ReceiptPrinter();
				for (Product product : purchaseCart.getPurchaseItems()) {
					printer.purchaseList(product);
				}
				printer.lineBreak();
				printer.taxes(calc.getTotalTax());
				printer.totalSale(calc.getTotalSale());
			}
		}
	}
}
