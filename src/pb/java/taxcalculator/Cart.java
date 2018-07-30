package pb.java.taxcalculator;

// To hold multiple items

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> purchaseItems = new ArrayList<Product>();

	public Product addProduct(int quantity, String desc, Double price) {
		Product product = new Product(quantity, desc, price);
		this.purchaseItems.add(product);
		return product;
	}

	public List<Product> getPurchaseItems() {
		return this.purchaseItems;
	}
}
