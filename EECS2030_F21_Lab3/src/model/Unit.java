package model;

public class Unit {
	private String name;
	private double width;
	private double length;
	
	private String report;
	private boolean measurement; // false means in inches, and true means in meters
	
	/* Constructor */
	public Unit(String n, int w, int l) {
		this.name = n;
		this.width = w;
		this.length = l;
		this.report = String.format("A unit of %.0f square feet (%.0f' wide and %.0f' long) functioning as %s", 
										(this.width*this.length), this.width, this.length, this.name);
		
	}
	
	/* Accessors */
	public String getName() {
		return this.name;
	}
	public double getWidth() {
		return this.width;
	}
	public double getLength() {
		return this.length;
	}
	public String toString() {
		return report;
	}
	public boolean equals(Object u) {
		if (this == u) {
			return true;
		}
		if (u == null) {
			return false;
		}
		Unit other = (Unit) u;
		return (this.name == other.name) && (this.width*this.length == other.getWidth()*other.getLength());
	}
	
	/* Mutators */
	public void toogleMeasurement() {
		this.measurement = !measurement; // false will be true and if true, will be false
		
		if (!measurement) {
			this.width /= 0.3048;
			this.length /= 0.3048;
			this.report = String.format("A unit of %.0f square feet (%.0f' wide and %.0f' long) functioning as %s", 
					(this.width*this.length), this.width, this.length, this.name);
		}
		else {
			this.width *= 0.3048;
			this.length *= 0.3048;
			this.report = String.format("A unit of %.2f square meters (%.2f m wide and %.2f m long) functioning as %s", 
					(this.width*this.length), this.width, this.length, this.name);
		}
	}
	
}
