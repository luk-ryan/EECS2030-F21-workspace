package model;

public class NonResidentStudent extends Student {
	private double discountRate;
	
	/* Constructors */
	public NonResidentStudent(String name) {
		super(name);
		this.discountRate = 0.0;
	}
	
	/* Accessors */
	public double getDiscountRate() {
		return this.discountRate;
	}
	
	public double getTuition() {
		this.tuition = super.getTuition() * this.discountRate;
		return this.tuition;
	}
	
	/* Mutators */
	public void setDiscountRate(double rate) {
		this.discountRate = rate;
	}
}
