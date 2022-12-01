package model;

public class Assessment {
	private String name;
	private double weight;
	private int mark;
	private String report;
	
	/* Constructors */
	public Assessment(String name, double weight) {
		this.name = name;
		this.weight = weight*100;
		this.mark = 0;
		this.report = String.format("Assessment created: %s accounts for %.3f percents of the course.", this.name, this.weight);
	}
	public Assessment(String name, double weight, int m) {
		this.name = name;
		this.weight = weight*100;
		this.mark = m;
		this.report = String.format("Assessment created: %s accounts for %.3f percents of the course.", this.name, this.weight);
	}
	
	
	/* Accessors */
	public String getName() {
		return this.name;
	}
	public double getWeight() {
		return this.weight;
	}
	public int getMarks() {
		return this.mark;
	}
	public String toString() {
		return this.report;
	}
	
	
	/* Mutators */
	public void setMarks(int m) {
		int prevMark = this.mark;
		this.mark = m;
		this.report = String.format("Marks of assessment %s (accounting for %.3f percents of the course) is changed from %d to %d.", 
										this.name, this.weight, prevMark, this.mark);
	}
	public void setWeight(double w) {
		double prevWeight = this.weight;
		this.weight = w*100;
		this.report = String.format("Weight of assessment %s (with marks %d) is changed from %.3f percents to %.3f percents.", 
										this.name, this.mark, prevWeight, this.weight);
	}
	
}
