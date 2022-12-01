package model;

public class ResidentStudent extends Student{
	private double premiumRate;

	/* Constructors */
	public ResidentStudent(String name) {
		super(name);
		this.premiumRate = 0.0;
	}
	
	/* Accessors */
	public double getPremiumRate() {
		return this.premiumRate;
	}
	
	public double getTuition() {
		this.tuition = super.getTuition() * this.premiumRate;
		return this.tuition;
	}
	
	/* Mutators */
	public void setPremiumRate(double rate) {
		this.premiumRate = rate;
	}
}
