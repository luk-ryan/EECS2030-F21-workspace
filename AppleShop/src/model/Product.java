package model;

/*
 * Template for individual apple product in refurbished store.
 */
public class Product {
	
	/* attributes (private means they are only visible within current class) */
	private String model; // e.g.iPad Pro 12.9
	private String finish; // e.g. silver, space grey
	private int storage; // in the units of GB
	private boolean hasCellularConnectivity; // e.g. false(only wifi), true(wifi + cellular data)
	private double originalPrice; // e.g. 1789.00
	private double discountValue; // e.g. 200.00
	
	/* constructors */
	// as soon as any additional constructors are added, the default goes away
	public Product() {
		// do nothing. All attributes will be stored in their default values
	}
	
	// overloaded version of constructor
	public Product(String model, double originalPrice) {
		this.model = model;
		this.originalPrice = originalPrice;
	}
	
	/* accessors */
	public String getModel() {
		return this.model;
	}
	public String getFinish() {
		return this.finish;
	}
	public int getStorage() {
		return this.storage;
	}
	public boolean hasCellularConnectivity() {
		return this.hasCellularConnectivity;
	}
	public double getOriginalPrice() {
		return this.originalPrice;
	}
	public double getDiscountValue() {
		return this.discountValue;
	}
	
	public double getPrice() {
		// local variable declarations
		double price = 0.0;
		
		//computation
		price = this.originalPrice - this.discountValue;
		
		//return
		return price;
	}
	
	public String toString() {
		String s = "";
		
//		StringBuilder sb = new StringBuilder();
//		sb.append(model + " " + finish + " " + storage + "GB " 
//					+ "(cellular connectivity: " + hasCellularConnectivity + "): $("
//						+ String.format("%.2f", originalPrice) + " - " + String.format("%.2f", discountValue) + ")");
//		s = sb.toString();
		
//		s += model + " " + finish + " " + storage + "GB " 
//				+ "(cellular connectivity: " + hasCellularConnectivity + "): $("
//					+ String.format("%.2f", originalPrice) + " - " + String.format("%.2f", discountValue) + ")";
		
		s = String.format("%s %s %dGB (cellular connectivity: %s): $(%.2f - %.2f)", 
				this.model, this.finish, this.storage, this.hasCellularConnectivity,
				this.originalPrice, this.discountValue);
		
		return s;
	}
	
	/* mutators */
	public void setModel(String model) {
		this.model = model;
	}
	public void setFinish(String finish) {
		this.finish = finish;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public void setHasCellularConnectivity(boolean hasCellularConnectivity) {
		this.hasCellularConnectivity = hasCellularConnectivity;
	}
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}
	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}
}
