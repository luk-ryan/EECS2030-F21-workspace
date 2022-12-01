package model;

public class Course {
	private String name;
	private double fee;
	
	/* Constructors */
	public Course(String courseName, double fee) {
		this.name = courseName;
		this.fee = fee;
	}
	
	/* Accessors */
	public String getName() {
		return this.name;
	}
	public double getFee() {
		return this.fee;
	}
	
	/* Mutators */
}
