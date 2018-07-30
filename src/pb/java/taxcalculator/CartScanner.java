package pb.java.taxcalculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartScanner {
	private Cart cart;

	public CartScanner(String cart) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(cart));
			String productDesc;
			this.cart = new Cart();
			while ((productDesc = reader.readLine()) != null) {
				this.cart.addProduct(scanQuantity(productDesc), scanDesc(productDesc),
						scanPrice(productDesc));
			}
			reader.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	public Cart getPurchaseCart() {
		return this.cart;
	}

	private int scanQuantity(String desc) {
		Pattern p = Pattern.compile("^[\\d+]+");
		Matcher m = p.matcher(desc);
		m.find();
		return Integer.parseInt(m.group(0));
	}

	private String scanDesc(String desc) {
		Pattern p = Pattern.compile("(?!^\\d)[A-Za-z].+(?=\\sat\\s\\d+.\\d+$)");
		Matcher m = p.matcher(desc);
		m.find();
		return m.group(0);
	}

	private Double scanPrice(String desc) {
		Pattern p = Pattern.compile("\\d+.\\d+$");
		Matcher m = p.matcher(desc);
		m.find();
		return Double.parseDouble(m.group(0));
	}
}
