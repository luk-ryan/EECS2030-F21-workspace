package model;

/*
 * Template of a unit of storage in the apple refurbish shop
 * think of shop as a collection of entries
 */
public class Entry {
	private String serialNumber; // Unique number to entry

	/* type of attribute is a reference type, denoting existing class
	  * At runtime, attribute will store address of some Product object 
	  */
	private Product product;
	
	/* constructors */
	public Entry(String serialNumber, Product product) {
		this.serialNumber = serialNumber;
		this.product = product;
	}
	
	/* accessors */
	 public String getSerialNumber() {
		return this.serialNumber;
	}

	public Product getProduct() {
		return this.product;
	}
	
	public String toString() {
		return "[" + this.serialNumber + "] " + this.product.toString(); 
	}
	
	/* mutators */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	/*
	 * Overloaded version of the setProduct mutator
	 * This version of setProduct does not expect the user to create a Product object and pass it as an argument
	 */
	public void setProduct(String model, double originalPrice) {
		// this.product = new Product(model, originalPrice);
		Product p = new Product(model, originalPrice);
		this.product = p;
	}
}
